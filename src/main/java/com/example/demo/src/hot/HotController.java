package com.example.demo.src.hot;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.hot.model.GetHotRes;
import com.example.demo.src.user.UserProvider;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.INVALID_USER_JWT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/hot")
public class HotController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HotProvider hotProvider;
    private final UserProvider userProvider;
    @Autowired
    private final JwtService jwtService;

    //4-1
    @GetMapping("")
    public BaseResponse<List<GetHotRes>> getHots() {
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            int userIdx = userProvider.getUserById(userIdxByJwt).getUserIdx();

            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            List<GetHotRes> getHotRes = hotProvider.getHots();
            return new BaseResponse<>(getHotRes);
        }
        catch (BaseException e){
            return new BaseResponse<>((e.getStatus()));
        }

    }
}
