package com.example.demo.src.content.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetContentRes {
    private int contentIdx;
    private String sampleImgUrl;
    //카테고리 별 group by 필요

}
