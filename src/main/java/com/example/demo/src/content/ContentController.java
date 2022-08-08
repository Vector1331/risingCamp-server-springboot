package com.example.demo.src.content;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/content")
public class ContentController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContentProvider contentProvider;

    //6-1 영화, 시리즈 페이지 조회 API
    @ResponseBody
    @GetMapping("/{label}")
    public BaseResponse<List<GetContentRes>> getContents(@PathVariable("label") String label) {
        List<GetContentRes> getContentRes = contentProvider.getContents(label);
        return new BaseResponse<>(getContentRes);

    }

    //6-3 영화 or 시리즈 해당 카테고리별 전체 콘텐츠 조회 API
    @GetMapping("/{label}/{categoryIdx}")
    public BaseResponse<List<GetContentRes>> getCategoryMovies(@PathVariable("label") String label,
                                                               @PathVariable("categoryIdx") int categoryIdx) {
        List<GetContentRes> getContentRes = contentProvider.getCategoryContent(label, categoryIdx);
        return new BaseResponse<>(getContentRes);
    }




}
