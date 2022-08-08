package com.example.demo.src.content;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/content")
public class ContentController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContentProvider contentProvider;

    //6-1
    @ResponseBody
    @GetMapping("/{label}")
    public BaseResponse<List<GetContentRes>> getContents(@PathVariable("label") String label) {
        List<GetContentRes> getContentRes = contentProvider.getContents(label);
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
