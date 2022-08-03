package com.example.demo.src.content;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ContentDao {
    private final EntityManager em;

    public List<GetContentRes> getContents(String label) {
        List<Content> contents = em.createQuery("select c from Content c where c.label = :param", Content.class)
                .setParameter("param", label)
                .getResultList();
        return contents.stream()
                .map(m -> new GetContentRes(m.getContentIdx(), m.getSampleImgUrl()))
                .collect(Collectors.toList());
    }
}
