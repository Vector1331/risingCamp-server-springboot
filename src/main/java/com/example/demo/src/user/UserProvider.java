package com.example.demo.src.user;


import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.membership.model.Membership;
import com.example.demo.src.membership.model.MembershipDao;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.SHA256;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Transactional
@Service
@RequiredArgsConstructor
public class UserProvider {

    private final UserDao userDao;
    private final MembershipDao membershipDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<GetMembershipRes> getMembership() {
        List<GetMembershipRes> getMembershipRes = membershipDao.getMembership();
        return getMembershipRes;
    }

    public PostMembershipRes postMembership(PostMembershipReq postMembershipReq) {
        Membership membership = membershipDao.getMembershipById(postMembershipReq.getMemberShipIdx());
        User user = getUserById(postMembershipReq.getUserIdx());
        PostMembershipRes postMembershipRes = userDao.postMembership(user, membership);
        return postMembershipRes;

    }

    public User getUserById (int userIdx) {
        return userDao.getUserById(userIdx);
    }
    public GetUserRes getUser(int userIdx) {
        GetUserRes getUserRes = userDao.getUser(userIdx);
        return getUserRes;

    }

    public int checkEmail(String email) {

        return userDao.checkEmail(email);

    }

    public PostLoginRes logIn(PostLoginReq postLoginReq) throws BaseException{
        User user = userDao.getPwd(postLoginReq.getEmail());
        String encryptPwd;
        try {
            encryptPwd=new SHA256().encrypt(postLoginReq.getPassword());
        } catch (Exception ignored) {
            throw new BaseException(PASSWORD_DECRYPTION_ERROR);
        }

        if(user.getPasswd().equals(encryptPwd)){
            int userIdx = user.getUserIdx();
            String jwt = jwtService.createJwt(userIdx);
            return new PostLoginRes(userIdx,jwt);
        }
        else{
            throw new BaseException(FAILED_TO_LOGIN);
        }

    }

}
