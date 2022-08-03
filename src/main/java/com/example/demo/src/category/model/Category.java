package com.example.demo.src.category.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
