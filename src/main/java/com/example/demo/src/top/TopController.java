package com.example.demo.src.top;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.top.model.GetTopRes;
import com.example.demo.src.user.UserProvider;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.INVALID_USER_JWT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/top")
public class TopController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TopProvider topProvider;
    private final UserProvider userProvider;
    @Autowired
    private final JwtService jwtService;

    //5-1 TOP 10 시리즈&d영화 조회 API
    @ResponseBody
    @GetMapping("/{label}") //(GET)127.0.0.1:9000/api/top/:type  -> series & movie
    public BaseResponse<List<GetTopRes>> getTops(@PathVariable("label") String label) {
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            int userIdx = userProvider.getUserById(userIdxByJwt).getUserIdx();

            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            List<GetTopRes> getTopRes = topProvider.getTops(label);
            return new BaseResponse<>(getTopRes);
        }
        catch (BaseException e){
            return new BaseResponse<>((e.getStatus()));
        }
    }

}
