package com.yzall.designbytes.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VisionDTO {
    private String prompt;
    private List<String> keyword;
    private MultipartFile imageFile;
    private String imageUrl;
}
