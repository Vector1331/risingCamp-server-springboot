package com.example.demo.src.membership.model;

import com.example.demo.src.user.model.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "userMembership")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMembershipIdx")
    private int userMembershipIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="membershipIdx")
    private Membership membership;

    public UserMembership(User user, Membership membership) {
        this.user = user;
        this.membership = membership;
    }
}
