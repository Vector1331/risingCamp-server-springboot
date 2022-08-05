package com.example.demo.src.likecontent;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.content.model.GetContentRes;
import com.example.demo.src.likecontent.model.LikeContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LikeDao {
    private final EntityManager em;

    public List<GetContentRes> getLikeContent(int profileIdx) {
        List<LikeContent> likecontents = em.createQuery("select l from LikeContent l" +
                        " join l.content c" +
                        " where l.profile.profileIdx = :param", LikeContent.class)
                .setParameter("param", profileIdx)
                .getResultList();

        return likecontents.stream()
                .map(m-> new GetContentRes(m.getContent().getContentIdx(), m.getContent().getSampleImgUrl()))
                .collect(Collectors.toList());

    }
}
