package com.example.demo.src.news;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.news.model.GetNewRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/news")
public class NewsController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final NewsProvider newsProvider;

    /*@GetMapping("")
    public BaseResponse<List<GetNewRes>> getNews() {
        try{
            List<GetNewRes> getNewRes = newsProvider.getNews();
            return new BaseResponse<>(getNewRes);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }*/
    //3-1
    @GetMapping("")
    public BaseResponse<List<GetNewRes>> getNews() {

            List<GetNewRes> getNewRes = newsProvider.getNews();
            return new BaseResponse<>(getNewRes);

    }

}
