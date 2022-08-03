package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id @GeneratedValue
    private int userIdx;

    private String email;
    @Column(name = "pawsswd")
    private String password;
    private String phone;
    private String status;

    private String ID;
    private String userName;

}
