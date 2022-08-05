package com.example.demo.src.user.model;

import com.example.demo.src.profile.model.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue
    @Column(name = "userIdx")
    private int userIdx;

    private String email;
    @Column(name = "pawsswd")
    private String password;
    private String phone;
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Profile> profileList = new ArrayList<>();
}
