package com.example.demo.src.top.model;

import com.example.demo.src.content.model.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Top")
@Getter
@Setter
@NoArgsConstructor
public class Top {
    @Id
    @GeneratedValue
    @Column(name = "topIdx")
    private int topIdx;
    private String label;
    private int ranking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contentIdx")
    private Content content;
}
