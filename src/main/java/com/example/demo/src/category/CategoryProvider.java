package com.example.demo.src.category;

import com.example.demo.src.category.model.GetCategoryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryProvider {

    private final CategoryDao categoryDao;

    public List<GetCategoryRes> getCategories(String label) {
        List<GetCategoryRes> getCategoryRes = categoryDao.getCategories(label);
        return getCategoryRes;
    }
}
