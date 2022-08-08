package com.example.demo.src.membership.model;

import com.example.demo.src.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "userMembership")
@Getter
@Setter
@NoArgsConstructor
public class UserMembership {
    @Id
    @GeneratedValue
    @Column(name = "userMembershipIdx")
    private int userMembershipIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="membershipIdx")
    private Membership membership;
}
