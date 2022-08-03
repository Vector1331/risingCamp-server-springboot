package com.example.demo.src.hot.model;

import com.example.demo.src.content.model.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hot")
@Getter
@Setter
@NoArgsConstructor
public class Hot {
    @Id
    @GeneratedValue
    @Column(name = "hotIdx")
    private int hotIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contentIdx")
    private Content content;

}
