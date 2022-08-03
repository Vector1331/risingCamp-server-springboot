package com.example.demo.src.category;

import com.example.demo.src.category.model.Category;
import com.example.demo.src.category.model.GetCategoryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryDao {
    private final EntityManager em;

    public List<GetCategoryRes> getCategories(String label) {
        List<Category> categories = em.createQuery("select ct from Category ct where ct.label = :param", Category.class)
                .setParameter("param", label)
                .getResultList();
        return categories.stream()
                .map(m -> new GetCategoryRes(m.getCategoryIdx(), m.getType()))
                .collect(Collectors.toList());
    }


}
