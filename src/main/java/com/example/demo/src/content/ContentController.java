package com.example.demo.src.content;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/content")
public class ContentController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContentProvider contentProvider;

    //6-1
    @GetMapping("/movie")
    public BaseResponse<List<GetContentRes>> getMovies() {
        List<GetContentRes> getContentRes = contentProvider.getContents("movie");
        return new BaseResponse<>(getContentRes);
    }

    //6-2
    @GetMapping("/series")
    public BaseResponse<List<GetContentRes>> getSeries() {
        List<GetContentRes> getContentRes = contentProvider.getContents("series");
        return new BaseResponse<>(getContentRes);
    }
    //6-3
    @GetMapping("/movie/{categoryIdx}")
    public BaseResponse<List<GetContentRes>> getCategoryMovies(@PathVariable("categoryIdx") int categoryIdx) {
        List<GetContentRes> getContentRes = contentProvider.getCategoryContent(categoryIdx, "movie");
        return new BaseResponse<>(getContentRes);

    }

    //6-4
    @GetMapping("/series/{categoryIdx}")
    public BaseResponse<List<GetContentRes>> getCategorySeries(@PathVariable("categoryIdx") int categoryIdx) {
        List<GetContentRes> getContentRes = contentProvider.getCategoryContent(categoryIdx, "series");
        return new BaseResponse<>(getContentRes);
    }


}
