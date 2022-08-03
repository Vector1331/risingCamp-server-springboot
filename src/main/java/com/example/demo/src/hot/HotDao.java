package com.example.demo.src.hot;

import com.example.demo.src.hot.model.GetHotRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HotDao {
    private final EntityManager em;
//    public List<GetHotRes> getHots() {
//
//    }
}
