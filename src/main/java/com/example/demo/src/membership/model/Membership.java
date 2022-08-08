package com.example.demo.src.membership.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "membership")
@Getter
@Setter
@NoArgsConstructor
public class Membership {
    @Id
    @GeneratedValue
    @Column(name = "membershipIdx")
    private int membershipIdx;
    private String status;
    private String type;
    private int cost;
    private String unit;
    private String quality;
    private String resolution;
    private int otherDevice;

    @JsonIgnore
    @OneToMany(mappedBy = "membership")
    private List<UserMembership> userMemberships =  new ArrayList<>();

}
