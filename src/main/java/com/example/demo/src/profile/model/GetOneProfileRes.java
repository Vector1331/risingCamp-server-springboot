package com.example.demo.src.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetOneProfileRes {
    private int profileIdx;
    private String profileName;
    private String imgUrl;
    private int isNext;
    private int isPreview;
}
