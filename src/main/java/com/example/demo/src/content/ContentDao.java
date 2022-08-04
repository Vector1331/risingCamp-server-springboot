package com.example.demo.src.content;

import com.example.demo.src.category.model.ContentCategory;
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

    public List<GetContentRes> getCategoryContent(int categoryIdx, String label) {
        List<ContentCategory> contentCategories = em.createQuery("select cc from ContentCategory cc" +
                        " join cc.content c" +
                        " where cc.category.categoryIdx = :param" +
                        " and c.label = :label" +
                        " group by c.title", ContentCategory.class)
                .setParameter("param", categoryIdx)
                .setParameter("label" , label)
                .getResultList();
        return contentCategories.stream()
                .map(m -> new GetContentRes(m.getContent().getContentIdx(), m.getContent().getSampleImgUrl()))
                .collect(Collectors.toList());


    }
}
