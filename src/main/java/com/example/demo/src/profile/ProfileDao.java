package com.example.demo.src.profile;

import com.example.demo.src.profile.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProfileDao {
    private final EntityManager em;

    public PostProfileRes createProfile(Profile profile) {
        em.persist(profile);
        return new PostProfileRes(profile.getProfileIdx());

    }

    public List<GetProfileRes> findProfile(int userIdx) {
        List<Profile> profile = em.createQuery("select p from Profile p where p.user.userIdx = :param", Profile.class)
                .setParameter("param", userIdx)
                .getResultList();
        return profile.stream()
                .map(m-> new GetProfileRes(m.getProfileIdx(), m.getName(), m.getImageUrl()))
                .collect(Collectors.toList());

    }

    public GetOneProfileRes findProfileById(int profileIdx) {
        Profile p =  em.createQuery("select p from Profile p where p.profileIdx = :param", Profile.class)
                .setParameter("param", profileIdx)
                .getSingleResult();
        return new GetOneProfileRes(p.getProfileIdx(), p.getName(), p.getImageUrl(), p.getIsNext(), p.getIsPreview());
    }

    public PatchProfileRes modifyProfile(int profileIdx, PatchProfileReq p) {

        em.createQuery("update Profile p" +
                        " set p.name = :name, p.imageUrl = :imgUrl, p.isNext = :isNext, p.isPreview = :isPre" +
                        " where p.profileIdx = :idx")
                .setParameter("name", p.getProfileName())
                .setParameter("imgUrl", p.getImgUrl())
                .setParameter("isNext", p.getIsNext())
                .setParameter("isPre", p.getIsPreview())
                .setParameter("idx", profileIdx)
                .executeUpdate();
        return new PatchProfileRes(profileIdx);
    }
}
