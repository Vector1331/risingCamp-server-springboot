package com.example.demo.src.content;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.content.model.GetContentRes;
import com.example.demo.src.user.UserProvider;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.INVALID_USER_JWT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/content")
public class ContentController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContentProvider contentProvider;
    private final UserProvider userProvider;
    @Autowired
    private final JwtService jwtService;

    //6-1 영화, 시리즈 페이지 조회 API
    @ResponseBody
    @GetMapping("/{label}")
    public BaseResponse<List<GetContentRes>> getContents(@PathVariable("label") String label) {
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            int userIdx = userProvider.getUserById(userIdxByJwt).getUserIdx();

            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            List<GetContentRes> getContentRes = contentProvider.getContents(label);
            return new BaseResponse<>(getContentRes);
        } catch (BaseException e) {
            return new BaseResponse<>((e.getStatus()));
        }

    }

    //6-3 영화 or 시리즈 해당 카테고리별 전체 콘텐츠 조회 API
    @GetMapping("/{label}/{categoryIdx}")
    public BaseResponse<List<GetContentRes>> getCategoryMovies(@PathVariable("label") String label,
                                                               @PathVariable("categoryIdx") int categoryIdx) {
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            int userIdx = userProvider.getUserById(userIdxByJwt).getUserIdx();

            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            List<GetContentRes> getContentRes = contentProvider.getCategoryContent(label, categoryIdx);
            return new BaseResponse<>(getContentRes);
        } catch (BaseException e) {
            return new BaseResponse<>((e.getStatus()));
        }
    }


}
