package com.example.demo.src.content;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/content")
public class ContentController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContentProvider contentProvider;

    @GetMapping("/movie")
    public BaseResponse<List<GetContentRes>> getMovies() {
        List<GetContentRes> getContentRes = contentProvider.getContents("movie");
        return new BaseResponse<>(getContentRes);

    }
    @GetMapping("/series")
    public BaseResponse<List<GetContentRes>> getSeries() {
        List<GetContentRes> getContentRes = contentProvider.getContents("series");
        return new BaseResponse<>(getContentRes);

    }

}
