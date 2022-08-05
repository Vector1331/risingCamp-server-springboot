package com.example.demo.src.save;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.save.model.GetSaveRes;
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
@RequestMapping("/app/saves")
public class SaveController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SaveProvider saveProvider;

    @GetMapping("/{profileIdx}")
    public BaseResponse<List<GetSaveRes>> getSaves(@PathVariable("profileIdx") int profileIdx){
        List<GetSaveRes> getSaveRes = saveProvider.getSaveContents(profileIdx);
        return new BaseResponse<>(getSaveRes);
    }
}
