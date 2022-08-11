package com.example.demo.src.user.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonAutoDetect
public class PostMembershipReq {
    private int userIdx;
    private int memberShipIdx;
}
