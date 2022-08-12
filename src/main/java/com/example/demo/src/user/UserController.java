package com.example.demo.src.user;

import com.example.demo.utils.SHA256;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


import static com.example.demo.config.BaseResponseStatus.*;
import static com.example.demo.utils.ValidationRegex.isRegexEmail;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/users")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final UserProvider userProvider;
//    @Autowired
    private final UserService userService;
    private final UserDao userDao;
    @Autowired
    private final JwtService jwtService;

    // 1-1 회원가입 1단계 API (이메일,비번,약관동의)
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostUserRes> createUser(@RequestBody @Valid PostUserReq postUserReq) {

        if(postUserReq.getEmail() == null){
            return new BaseResponse<>(POST_USERS_EMPTY_EMAIL);
        }
        try {
            PostUserRes postUserRes = userService.createUser(postUserReq);
            return new BaseResponse<>(postUserRes);
        }catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
        /*
        //이메일 정규표현
        if(!isRegexEmail(postUserReq.getEmail())){
            return new BaseResponse<>(POST_USERS_INVALID_EMAIL);
        }
        try{
            PostUserRes postUserRes = userService.createUser(postUserReq);
            return new BaseResponse<>(postUserRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }*/
    }


    //1-2 회원가입 2단계 멤버쉽 조회 API [GET]
    @GetMapping("/planform")
    public BaseResponse<List<GetMembershipRes>> getMembership() {
        List<GetMembershipRes> getMembershipRes = userProvider.getMembership();
        return new BaseResponse<>(getMembershipRes);
    }

    //1-3 회원가입 2단계 멤버쉽 등록 API [POST]
    @PostMapping("/planform")
    public BaseResponse<PostMembershipRes> postMembership(@RequestBody @Valid PostMembershipReq postMembershipReq) {
        PostMembershipRes postMembershipRes = userProvider.postMembership(postMembershipReq);
        return new BaseResponse<>(postMembershipRes);
    }



    // 1-5 회원 1명 조회 API [GET]
    @ResponseBody
    @GetMapping("/{userIdx}") // (GET) 127.0.0.1:9000/app/users/:userIdx
    public BaseResponse<GetUserRes> getUser(@PathVariable("userIdx") int userIdx) {

        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            //userIdx와 접근한 유저가 같은지 확인
            if (userIdx != userIdxByJwt) {
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            // Get Users
            GetUserRes getUserRes = userProvider.getUser(userIdx);
            return new BaseResponse<>(getUserRes);
        }
        catch (BaseException e){
            return new BaseResponse<>((e.getStatus()));
        }

    }


    //1-6 로그인 API [POST]
    @ResponseBody
    @PostMapping("/logIn")
    public BaseResponse<PostLoginRes> logIn(@RequestBody PostLoginReq postLoginReq){
        try{
            PostLoginRes postLoginRes = userProvider.logIn(postLoginReq);
            return new BaseResponse<>(postLoginRes);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    //1-7 유저 이메일 정보변경 API [PATCH]
    @ResponseBody
    @PatchMapping("email/{userIdx}")
    public BaseResponse<String> modifyUserName(@PathVariable("userIdx") int userIdx, @RequestBody User user){
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            //userIdx와 접근한 유저가 같은지 확인
            if(userIdx != userIdxByJwt){
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            //user 비밀번호가 같은지 확인
            String userEmail = userProvider.getUser(userIdx).getEmail();
            String encryptPwd = new SHA256().encrypt(user.getPasswd());
            User user1 = userDao.getPwd(userEmail);

            if(user1.getPasswd().equals(encryptPwd)){
                //같다면 유저이메일 변경
                PatchUserReq patchUserReq = new PatchUserReq(userIdx,user.getEmail());
                userService.modifyUserEmail(patchUserReq);

                String result = "이메일 변경에 성공했습니다.";
                return new BaseResponse<>(result);
            }
            else {return new BaseResponse<>("비밀번호 오류");}


        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @PatchMapping("pwd/{userIdx}")public BaseResponse<String> modifyUserPwd(@PathVariable("userIdx") int userIdx, @RequestBody PatchUserPwdReq patchUserPwdReq){
        try {
            //jwt에서 idx 추출.
            int userIdxByJwt = jwtService.getUserIdx();
            //userIdx와 접근한 유저가 같은지 확인
            if(userIdx != userIdxByJwt){
                return new BaseResponse<>(INVALID_USER_JWT);
            }
            //기존 비밀번호가 같은지 확인

            String encryptPwd = new SHA256().encrypt(patchUserPwdReq.getOriginPwd());   //request 기존비번
            String userEmail = userProvider.getUser(userIdx).getEmail();
            User user1 = userDao.getPwd(userEmail);

            if(user1.getPasswd().equals(encryptPwd)){
                //같다면 유저 비밀번호변경
                userService.modifyUserPwd(user1.getUserIdx(), patchUserPwdReq);
                String result = "비밀번호 변경에 성공했습니다.";
                return new BaseResponse<>(result);
            }
            else {return new BaseResponse<>("기존 비밀번호와 같지않습니다.");}


        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
