package com.example.demo.src.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCategoryRes {
    private int categoryIdx;
    private String type;

}
