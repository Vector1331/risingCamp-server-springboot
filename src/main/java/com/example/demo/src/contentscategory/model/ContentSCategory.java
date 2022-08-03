package com.example.demo.src.contentscategory.model;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.seriescategory.model.SeriesCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "content_s_category")
@Getter
@Setter
@NoArgsConstructor
public class ContentSCategory {
    @Id
    @GeneratedValue
    @Column(name = "content_s_category_idx")
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="content_idx")
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="series_category_idx")
    private SeriesCategory seriesCategory;
    private Integer category_idx;
}
