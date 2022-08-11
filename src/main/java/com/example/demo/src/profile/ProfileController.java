package com.example.demo.src.profile;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.profile.model.GetOneProfileRes;
import com.example.demo.src.profile.model.GetProfileRes;
import com.example.demo.src.profile.model.PostProfileReq;
import com.example.demo.src.profile.model.PostProfileRes;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.INVALID_USER_JWT;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/profiles")
public class ProfileController {
    @Autowired
    private final ProfileProvider profileProvider;
    @Autowired
    private final JwtService jwtService;

    //2-1 프로필 등록 API
    @ResponseBody
    @PostMapping("/{userIdx}")
    public BaseResponse<PostProfileRes> createProfile(@PathVariable("userIdx") int userIdx,
                                                      @RequestBody PostProfileReq postProfileReq){
        try{
            int userIdxByJwt = jwtService.getUserIdx();
            if(userIdx != userIdxByJwt){
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            return new BaseResponse<>(profileProvider.createProfile(userIdx,postProfileReq));
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }

    //2-2 등록된 프로필 조회 API
    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<List<GetProfileRes>> createProfile(@PathVariable("userIdx") int userIdx){
        try{
            int userIdxByJwt = jwtService.getUserIdx();
            if(userIdx != userIdxByJwt){
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            return new BaseResponse<>(profileProvider.findProfile(userIdx));
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }

    //2-3 프로필 1개 조회 API
    @ResponseBody
    @GetMapping("{userIdx}/{profileIdx}")
    public BaseResponse<GetOneProfileRes> getProfile(@PathVariable("userIdx") int userIdx,
                                                     @PathVariable("profileIdx") int profileIdx) {
        try{
            int userIdxByJwt = jwtService.getUserIdx();
            if(userIdx != userIdxByJwt){
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            return new BaseResponse<GetOneProfileRes>(profileProvider.findProfileById(profileIdx));
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }


}
