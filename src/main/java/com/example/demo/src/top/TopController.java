package com.example.demo.src.top;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.top.model.GetTopRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/top")
public class TopController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TopProvider topProvider;

    @GetMapping("/series")
    public BaseResponse<List<GetTopRes>> getTopSeries() {
        List<GetTopRes> getTopRes = topProvider.getTops("series");
        return new BaseResponse<>(getTopRes);
    }
    @GetMapping("/movie")
    public BaseResponse<List<GetTopRes>> getTopMovies() {
        List<GetTopRes> getTopRes = topProvider.getTops("movie");
        return new BaseResponse<>(getTopRes);
    }
}
