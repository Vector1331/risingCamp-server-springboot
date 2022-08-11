package com.example.demo.src.user;


import com.example.demo.config.BaseException;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.SHA256;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.config.BaseResponseStatus.*;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserDao userDao;
    private final UserProvider userProvider;
    private final JwtService jwtService;


    public PostUserRes createUser(PostUserReq postUserReq) throws BaseException {
        //중복
        if (userProvider.checkEmail(postUserReq.getEmail()) == 1) {
            throw new BaseException(POST_USERS_EXISTS_EMAIL);
        }

        String pwd;
        try {
            //암호화
            pwd = new SHA256().encrypt(postUserReq.getPasswd());
            postUserReq.setPasswd(pwd);
        } catch (Exception ignored) {
            throw new BaseException(PASSWORD_ENCRYPTION_ERROR);
        }
        try {
            User user = User.createUser(postUserReq.getEmail(), postUserReq.getPasswd(), postUserReq.getPhone(), "active", postUserReq.getPolicyCheck());

            int userIdx = userDao.saveUser(user);

            return new PostUserRes(userIdx);
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
        //jwt 발급.
        //String jwt = jwtService.createJwt(userIdx);
        //return new PostUserRes(jwt,userIdx);

    }


    public void modifyUserEmail(PatchUserReq patchUserReq) throws BaseException {
        try{
            int result = userDao.modifyUserName(patchUserReq);
            if(result == 0){
                throw new BaseException(MODIFY_FAIL_USERNAME);
            }
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void modifyUserPwd(int userIdx, PatchUserPwdReq patchUserPwdReq)  throws BaseException {
        try{
            //암호화
            String pwd = new SHA256().encrypt(patchUserPwdReq.getNewPwd());
            PatchUserPwd patchUserPwd = new PatchUserPwd(userIdx,pwd);
            int result = userDao.modifyUserPwd(patchUserPwd);
            if(result == 0){
                throw new BaseException(MODIFY_FAIL_USERNAME);
            }
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
