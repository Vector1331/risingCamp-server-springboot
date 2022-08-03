package com.example.demo.src.top;

import com.example.demo.src.top.model.GetTopRes;
import com.example.demo.src.top.model.Top;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TopDao {
    private final EntityManager em;

    public List<GetTopRes> getTops(String label) {
        List<Top> tops = em.createQuery("select t from Top t join fetch t.content c where t.label = :param", Top.class)
                .setParameter("param", label)
                .getResultList();

        return tops.stream()
                .map(m -> new GetTopRes(m.getTopIdx(), m.getRanking(), m.getContent().getTitle(), m.getContent().getInfo(), m.getContent().getPreviewUrl(), m.getContent().getAge()))
                .collect(Collectors.toList());
    }
}
