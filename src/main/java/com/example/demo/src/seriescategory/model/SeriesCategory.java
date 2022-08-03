package com.example.demo.src.seriescategory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "series_category")
@Getter
@Setter
@NoArgsConstructor
public class SeriesCategory {
    @Id
    @GeneratedValue
    @Column(name = "series_category_idx")
    private int seriesCategoryIdx;
    private String type;
}
