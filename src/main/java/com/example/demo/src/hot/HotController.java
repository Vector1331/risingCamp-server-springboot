package com.example.demo.src.hot;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.hot.model.GetHotRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/hot")
public class HotController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HotProvider hotProvider;

    //4-1
    @GetMapping("")
    public BaseResponse<List<GetHotRes>> getHots() {
        List<GetHotRes> getHotRes = hotProvider.getHots();
        return new BaseResponse<>(getHotRes);

    }
}
