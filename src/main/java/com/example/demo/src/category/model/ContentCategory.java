package com.example.demo.src.category.model;

import com.example.demo.src.content.model.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contentCategory")
@Getter
@Setter
@NoArgsConstructor
public class ContentCategory {
    @Id
    @GeneratedValue
    @Column(name = "content_category_idx")
    private int contentCategoryIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contentIdx")
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryIdx")
    private Category category;

}
