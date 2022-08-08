package com.example.demo.src.top;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.top.model.GetTopRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/top")
public class TopController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TopProvider topProvider;

    //5-1 TOP 10 시리즈&d영화 조회 API
    @ResponseBody
    @GetMapping("/{label}") //(GET)127.0.0.1:9000/api/top/:type  -> series & movie
    public BaseResponse<List<GetTopRes>> getTops(@PathVariable("label") String label) {
        List<GetTopRes> getTopRes = topProvider.getTops(label);
        return new BaseResponse<>(getTopRes);
    }

}
