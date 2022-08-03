package com.example.demo.src.news.model;

import com.example.demo.src.category.model.Category;
import com.example.demo.src.moviecategory.model.MovieCategory;
import com.example.demo.src.seriescategory.model.SeriesCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetNewRes {
    private int newsIdx;
    private String openDate;
    private String title;
    private String info;
    private String previewUrl;
    //카테고리 필요
    //알림 받기 필요

}
