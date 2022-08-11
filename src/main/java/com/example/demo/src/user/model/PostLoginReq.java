package com.example.demo.src.user.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@NoArgsConstructor
@JsonAutoDetect
public class PostLoginReq {
    private String email;
    private String password;
}
