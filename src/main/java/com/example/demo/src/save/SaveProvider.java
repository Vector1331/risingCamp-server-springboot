package com.example.demo.src.save;

import com.example.demo.src.save.model.GetSaveRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SaveProvider {
    private final SaveDao saveDao;
    public List<GetSaveRes> getSaveContents(int profileIdx) {
        List<GetSaveRes> getSaveRes = saveDao.getSaveContents(profileIdx);
        return getSaveRes;
    }
}
