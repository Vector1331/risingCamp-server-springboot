package com.example.demo.src.category;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.category.model.GetCategoryRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/category")
public class CategoryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CategoryProvider categoryProvider;

    //7-1 영화 or 시리즈 콘텐츠의 전체 카테고리 조회 API
    @ResponseBody
    @GetMapping("/{label}")
    public BaseResponse<List<GetCategoryRes>> getCategories(@PathVariable("label") String label) {
        List<GetCategoryRes> getCategoryRes = categoryProvider.getCategories(label);
        return new BaseResponse<>(getCategoryRes);
    }



}
