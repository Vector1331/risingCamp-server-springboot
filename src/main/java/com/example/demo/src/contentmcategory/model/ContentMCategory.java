package com.example.demo.src.contentmcategory.model;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.moviecategory.model.MovieCategory;
import com.example.demo.src.seriescategory.model.SeriesCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "content_m_category")
@Getter
@Setter
@NoArgsConstructor
public class ContentMCategory {
    @Id
    @GeneratedValue
    @Column(name = "content_m_category_idx")
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="content_idx")
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie_category_idx")
    private MovieCategory movieCategory;
    private Integer category_idx;
}
