package com.example.demo.src.profile.model;

import com.example.demo.src.likecontent.model.LikeContent;
import com.example.demo.src.profile.model.save.model.SaveContent;
import com.example.demo.src.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue
    @Column(name = "profileIdx")
    private int profileIdx;
    private String name;
    private String imageUrl;
    private String passwd;
    private String status;
    private String isKids;
    private String isNext;
    private String isPreview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userIdx")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private List<LikeContent> likeContents = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private List<SaveContent> saveContents = new ArrayList<>();





}
