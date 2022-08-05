package com.example.demo.src.save.model;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.profile.model.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "saveContent")
@Getter
@Setter
@NoArgsConstructor
public class SaveContent {
    @Id
    @GeneratedValue
    @Column(name = "saveContentIdx")
    private int saveContentIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contentIdx")
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profileIdx")
    private Profile profile;

    private String status;
    private Integer detailContentIdx;
}
