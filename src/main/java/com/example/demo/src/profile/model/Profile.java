package com.example.demo.src.profile.model;

import com.example.demo.src.likecontent.model.LikeContent;
import com.example.demo.src.save.model.SaveContent;
import com.example.demo.src.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profileIdx")
    private int profileIdx;
    private String name;
    private String imageUrl;
    private String passwd;
    private String status;
    private int isKids;
    private int isNext;
    private int isPreview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userIdx")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private List<LikeContent> likeContents = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private List<SaveContent> saveContents = new ArrayList<>();


    public Profile(String profileName, String imgUrl, int isKids, int isNext, int isPreview, String status, User user) {
        this.name = profileName;
        this.imageUrl = imgUrl;
        this.isKids = isKids;
        this.isNext = isNext;
        this.isPreview = isPreview;
        this.status = status;
        this.user = user;
    }
}
