package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetMembershipRes {
    private int memberShipIdx;
    private String type;
    private int cost;
    private String unit;
    private String quality;
    private String resolution;
    private int otherDevice;

}
