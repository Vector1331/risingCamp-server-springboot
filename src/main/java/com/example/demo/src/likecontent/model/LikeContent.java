package com.example.demo.src.likecontent.model;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.profile.model.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "likeContent")
@Getter
@Setter
@NoArgsConstructor
public class LikeContent {
    @Id
    @GeneratedValue
    @Column(name = "likeContentIdx")
    private int likeIdx;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contentIdx")
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profileIdx")
    private Profile profile;
}
