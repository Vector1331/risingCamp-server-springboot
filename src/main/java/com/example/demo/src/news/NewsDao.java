package com.example.demo.src.news;

import com.example.demo.src.news.model.GetNewRes;
import com.example.demo.src.news.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class NewsDao {
    private final EntityManager em;
    public List<GetNewRes> getNews() {
        //String getNewsQuery = "select n from News n";
        List<News> news =  em.createQuery("select n from News n join fetch n.content c", News.class)
                .getResultList();
        return news.stream()
                    .map(m -> new GetNewRes(m.getNewsIdx(), m.getOpenDate(), m.getContent().getTitle(), m.getContent().getInfo(), m.getContent().getPreviewUrl()))
                    .collect(Collectors.toList());

    }
}
