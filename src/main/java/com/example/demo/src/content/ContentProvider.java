package com.example.demo.src.content;

import com.example.demo.src.content.model.GetContentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContentProvider {
    private final ContentDao contentDao;
    public List<GetContentRes> getContents(String label) {
        List<GetContentRes> getContentRes = contentDao.getContents(label);
        return getContentRes;
    }
}
