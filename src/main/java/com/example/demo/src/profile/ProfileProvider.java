package com.example.demo.src.profile;

import com.example.demo.src.profile.model.GetProfileRes;
import com.example.demo.src.profile.model.PostProfileReq;
import com.example.demo.src.profile.model.PostProfileRes;
import com.example.demo.src.profile.model.Profile;
import com.example.demo.src.user.UserDao;
import com.example.demo.src.user.model.User;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ProfileProvider {
    private final ProfileDao profileDao;
    private final UserDao userDao;

    private final JwtService jwtService;


    public PostProfileRes createProfile(int userIdx, PostProfileReq postProfileReq) {
        User user = userDao.getUserById(userIdx);
        Profile profile = new Profile(postProfileReq.getProfileName(), postProfileReq.getImgUrl(), postProfileReq.getIsKids(), "active", user);
        return profileDao.createProfile(profile);
    }

    public List<GetProfileRes> findProfile(int userIdx) {
        return profileDao.findProfile(userIdx);

    }
}
