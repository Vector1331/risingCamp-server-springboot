package com.example.demo.src.moviecategory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movie_category")
@Getter
@Setter
@NoArgsConstructor
public class MovieCategory {
    @Id
    @GeneratedValue
    @Column(name = "movie_category_idx")
    private int movieCategoryIdx;
    private String type;
}

