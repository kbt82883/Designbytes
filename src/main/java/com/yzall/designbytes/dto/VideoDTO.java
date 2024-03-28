package com.yzall.designbytes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VideoDTO {
    private Integer videoNo;
    private String videoTitle;
    private String videoUrl;
    private Integer videoRunningTime;
    private String videoMakerId;
    private String videoMakerName;
    private Integer videoFileSize;
    private char videoPaidYn;
    private Integer videoPrice;
    private Integer videoThumbnailId;
}
