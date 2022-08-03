package com.example.demo.src.top.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetTopRes {
    private int topIdx;
    private int ranking;
    private String title;
    private String info;
    private String previewUrl;
    private Integer age;
    //찜여부 필요
}
