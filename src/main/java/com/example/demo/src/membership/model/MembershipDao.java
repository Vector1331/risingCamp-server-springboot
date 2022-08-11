package com.example.demo.src.membership.model;

import com.example.demo.src.user.model.GetMembershipRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MembershipDao {
    private final EntityManager em;
    public List<GetMembershipRes> getMembership() {
        List<Membership> memberships = em.createQuery("select m from Membership m", Membership.class)
                .getResultList();
        return memberships.stream()
                .map(m-> new GetMembershipRes(m.getMembershipIdx(), m.getType(), m.getCost(), m.getUnit(), m.getQuality(), m.getResolution(), m.getOtherDevice()))
                .collect(Collectors.toList());

    }
    public Membership getMembershipById(int membershipIdx){
        Membership membership = em.createQuery("select m from Membership m where m.membershipIdx = :param", Membership.class)
                .setParameter("param", membershipIdx)
                .getSingleResult();
        return membership;
    }
}
