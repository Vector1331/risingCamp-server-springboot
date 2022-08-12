package com.example.demo.src.credit.model;

import com.example.demo.src.content.model.Content;
import com.example.demo.src.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "credit")
@Getter
@Setter
@NoArgsConstructor
public class Credit {
    @Id
    @GeneratedValue
    @Column(name = "creditIdx")
    private int creditIdx;
    private int cost;
    private String unit;
    private int tax;
    private String ServiceBegin;
    private String ServiceEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userIdx")
    private User user;

}
