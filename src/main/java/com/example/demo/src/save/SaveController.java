package com.example.demo.src.save;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.content.model.GetContentRes;
import com.example.demo.src.likecontent.LikeProvider;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/app/saves")
public class SaveController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SaveProvider saveProvider;

    @GetMapping("/{profileIdx}")
    public BaseResponse<List<GetContentRes>> getLikes(@PathVariable("profileIdx") int profileIdx){
        List<GetContentRes> getContentRes = saveProvider.getLikeContent(profileIdx);
        return new BaseResponse<>(getContentRes);
    }
}
