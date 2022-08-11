package com.example.demo.src.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchProfileReq {
    private String profileName;
    private String imgUrl;
    private int isNext;
    private int isPreview;
}
