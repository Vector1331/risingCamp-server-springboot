package com.example.demo.src.news.model;

import com.example.demo.src.category.model.Category;
import com.example.demo.src.moviecategory.model.MovieCategory;
import com.example.demo.src.seriescategory.model.SeriesCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
public class GetNewRes {
    private int newsIdx;
    private String previewUrl;
    private String title;
    private String info;
    private String openDate;
//    @Nullable
//    private List<Category> category;
//    @Nullable
//    private List<MovieCategory> movieCategories;
//    @Nullable
//    private List<SeriesCategory> seriesCategories;
}
