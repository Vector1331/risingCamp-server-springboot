package com.example.demo.src.category;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.category.model.GetCategoryRes;
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
@RequestMapping("/app/category")
public class CategoryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CategoryProvider categoryProvider;
    private final UserProvider userProvider;
    @Autowired
    private final JwtService jwtService;

    //7-1 영화 or 시리즈 콘텐츠의 전체 카테고리 조회 API
    @ResponseBody
    @GetMapping("/{label}")
    public BaseResponse<List<GetCategoryRes>> getCategories(@PathVariable("label") String label) {
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            int userIdx = userProvider.getUserById(userIdxByJwt).getUserIdx();

            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            List<GetCategoryRes> getCategoryRes = categoryProvider.getCategories(label);
            return new BaseResponse<>(getCategoryRes);
        } catch (BaseException e) {
            return new BaseResponse<>((e.getStatus()));
        }
    }


}
