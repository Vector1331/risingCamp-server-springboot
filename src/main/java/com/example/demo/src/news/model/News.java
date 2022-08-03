package com.example.demo.src.news.model;

import com.example.demo.src.content.model.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "News")
@Getter
@Setter
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue
    @Column(name = "newsIdx")
    private int newsIdx;
    @Column(name = "openDate")
    private String openDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contentIdx")
    private Content content;

}
