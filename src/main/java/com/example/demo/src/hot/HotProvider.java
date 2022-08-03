package com.example.demo.src.hot;

import com.example.demo.src.hot.model.GetHotRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotProvider {
    private final HotDao hotDao;
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<GetHotRes> getHots() {
        List<GetHotRes> getHotRes = hotDao.getHots();
        return getHotRes;
    }

}
