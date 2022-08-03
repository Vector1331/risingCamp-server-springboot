package com.example.demo.src.top;

import com.example.demo.src.top.model.GetTopRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopProvider {
    private final TopDao topDao;
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<GetTopRes> getTops(String label) {
        List<GetTopRes> getTopRes = topDao.getTops(label);
        return getTopRes;

    }
}
