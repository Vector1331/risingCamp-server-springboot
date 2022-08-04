package com.example.demo.src.category;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.category.model.GetCategoryRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/category")
public class CategoryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CategoryProvider categoryProvider;

    @GetMapping("/movie")
    public BaseResponse<List<GetCategoryRes>> getMovieCategories() {
        List<GetCategoryRes> getCategoryRes = categoryProvider.getCategories("movie");
        return new BaseResponse<>(getCategoryRes);
    }

    @GetMapping("/series")
    public BaseResponse<List<GetCategoryRes>> getSeriesCategories() {
        List<GetCategoryRes> getCategoryRes = categoryProvider.getCategories("series");
        return new BaseResponse<>(getCategoryRes);
    }


}
