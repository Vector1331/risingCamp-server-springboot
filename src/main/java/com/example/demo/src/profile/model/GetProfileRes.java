package com.example.demo.src.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProfileRes {
    private String profileName;
    private String imgUrl;

}
