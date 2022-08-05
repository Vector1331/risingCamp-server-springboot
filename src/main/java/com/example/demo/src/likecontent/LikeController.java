package com.example.demo.src.likecontent;

import com.example.demo.config.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.src.content.model.GetContentRes;
import java.util.List;@RestController
@RequiredArgsConstructor
@RequestMapping("/app/likes")
public class LikeController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final LikeProvider likeProvider;

    @GetMapping("/{profileIdx}")
    public BaseResponse<List<GetContentRes>> getLikes(@PathVariable("profileIdx") int profileIdx){
        List<GetContentRes> getContentRes = likeProvider.getLikeContent(profileIdx);
        return new BaseResponse<>(getContentRes);
    }

}
