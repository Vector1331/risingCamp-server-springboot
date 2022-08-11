package com.example.demo.src.profile;

import com.example.demo.src.profile.model.GetProfileRes;
import com.example.demo.src.profile.model.PostProfileReq;
import com.example.demo.src.profile.model.PostProfileRes;
import com.example.demo.src.profile.model.Profile;
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
                .map(m-> new GetProfileRes(m.getName(), m.getImageUrl()))
                .collect(Collectors.toList());

    }
}
