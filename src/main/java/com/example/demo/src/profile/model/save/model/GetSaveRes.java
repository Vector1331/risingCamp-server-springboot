package com.example.demo.src.profile.model.save.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetSaveRes {
    private int saveContentIdx;
    private Integer contentIdx;
    private String title;
    private Integer age;
    private Integer episodeCnt;
    private String sampleImgUrl;

}
