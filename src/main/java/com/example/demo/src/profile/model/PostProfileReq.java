package com.example.demo.src.profile.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAutoDetect
public class PostProfileReq {
    private String profileName;
    private String imgUrl;
    private int isKids;


}
