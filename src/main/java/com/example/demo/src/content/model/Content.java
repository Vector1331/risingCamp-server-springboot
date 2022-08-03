package com.example.demo.src.content.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "content")
@Getter
@Setter
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue
    @Column(name = "content_idx")
    private int contentIdx;
    private String label;
    private String title;
    private String info;
    @Column(name = "can_download")
    private int canDownload;
    private Integer age;
    private String runtime;
    @Column(name = "sample_img_url")
    private String sampleImgUrl;
    @Column(name = "preview_url")
    private String previewUrl;
    @Column(name = "content_url")
    private String contentUrl;
    @Column(name = "released_at")
    private String releasedAt;
    private String quality;
    private String status;



}
