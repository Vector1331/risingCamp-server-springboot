package com.example.demo.src.news.model;

import com.example.demo.src.category.model.Category;
import com.example.demo.src.category.model.GetCategoryRes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@NoArgsConstructor
public class GetNewRes {
    private int newsIdx;
    private String openDate;
    private String title;
    private String info;
    private String previewUrl;
    //카테고리 필요
    //private List<String> categories;

    public GetNewRes(int newsIdx, String openDate, String title, String info, String previewUrl) {
        this.newsIdx = newsIdx;
        this.openDate = openDate;
        this.title = title;
        this.info = info;
        this.previewUrl = previewUrl;
    }
    //private List<String> contnetCategory;
    //알림 받기 필요

}
