package com.example.demo.src.likecontent;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.UserProvider;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.src.content.model.GetContentRes;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.INVALID_USER_JWT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/likes")
public class LikeController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final LikeProvider likeProvider;
    private final UserProvider userProvider;
    @Autowired
    private final JwtService jwtService;

    @GetMapping("/{userIdx}/{profileIdx}")
    public BaseResponse<List<GetContentRes>> getLikes(@PathVariable("userIdx") int userIdx,
                                                      @PathVariable("profileIdx") int profileIdx) {
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();

            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            List<GetContentRes> getContentRes = likeProvider.getLikeContent(profileIdx);
            return new BaseResponse<>(getContentRes);
        } catch (BaseException e) {
            return new BaseResponse<>((e.getStatus()));
        }
    }

}
