package com.example.demo.src.likecontent;

import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeProvider {
    private final LikeDao likeDao;
    public List<GetContentRes> getLikeContent(int profileIdx) {
        List<GetContentRes> getContentRes = likeDao.getLikeContent(profileIdx);
        return getContentRes;
    }

}
