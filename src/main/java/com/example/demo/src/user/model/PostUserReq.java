package com.example.demo.src.user.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@NoArgsConstructor
@JsonAutoDetect
public class PostUserReq {
//    private String UserName;
//    private String id;
    private String email;
    private String passwd;
    private String phone;
}
