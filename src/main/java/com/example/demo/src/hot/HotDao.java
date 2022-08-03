package com.example.demo.src.hot;

import com.example.demo.src.hot.model.GetHotRes;
import com.example.demo.src.hot.model.Hot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class HotDao {
    private final EntityManager em;
    public List<GetHotRes> getHots() {
        List<Hot> hots = em.createQuery("select h from Hot h join fetch h.content c", Hot.class)
                .getResultList();
        return hots.stream()
                .map(m -> new GetHotRes(m.getHotIdx(), m.getContent().getTitle(), m.getContent().getInfo(), m.getContent().getPreviewUrl()))
                .collect(Collectors.toList());

    }
}
