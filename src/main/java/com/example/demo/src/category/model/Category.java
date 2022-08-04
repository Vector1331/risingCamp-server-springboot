package com.example.demo.src.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "categoryIdx")
    private int categoryIdx;
    private String label;
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<ContentCategory> contentCategories = new ArrayList<>();


}
