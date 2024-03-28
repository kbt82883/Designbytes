package com.yzall.designbytes.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_no")
    private Integer videoNo;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "video_running_time")
    private Integer videoRunningTime;

    @Column(name = "video_maker_id")
    private String videoMakerId;

    @Column(name = "video_maker_name")
    private String videoMakerName;

    @Column(name = "video_file_size")
    private Integer videoFileSize;

    @Column(name = "video_paid_yn")
    private char videoPaidYn;

    @Column(name = "video_price")
    private Integer videoPrice;

    @Column(name = "video_thumbnail_id")
    private Integer videoThumbnailId;
}
