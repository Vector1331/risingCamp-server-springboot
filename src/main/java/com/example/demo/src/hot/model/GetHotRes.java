package com.example.demo.src.hot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetHotRes {
    private int hotIdx;
    private String title;
    private String info;
    private String previewUrl;
    //찜여부

}
