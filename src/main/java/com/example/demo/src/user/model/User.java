package com.example.demo.src.user.model;

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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Profile> profileList = new ArrayList<>();

    public static User createUser(String email, String passwd, String phone, String status){
        User user = new User();
        user.setEmail(email);
        user.setPasswd(passwd);
        user.setPhone(phone);
        user.setStatus(status);

        return user;
    }

}
