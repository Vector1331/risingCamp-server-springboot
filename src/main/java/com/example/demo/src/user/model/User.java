package com.example.demo.src.user.model;

import com.example.demo.src.credit.model.Credit;
import com.example.demo.src.membership.model.UserMembership;
import com.example.demo.src.profile.model.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userIdx")
    private int userIdx;

    private String email;
    private String passwd;
    private String phone;
    private String status;
    private int policyCheck;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Profile> profileList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<UserMembership> userMemberships = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Credit> creditList = new ArrayList<>();

    public static User createUser(String email, String passwd, String phone, String status, int policyCheck){
        User user = new User();
        user.setEmail(email);
        user.setPasswd(passwd);
        user.setPhone(phone);
        user.setStatus(status);
        user.setPolicyCheck(policyCheck);

        return user;
    }

}
