package com.yzall.designbytes.dto.openai;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Content {
    public String type;
    public String text;
    public ImageUrl image_url;

    public Content(String type, String prompt) {
        this.type = type;
        this.text = prompt;
    }

    public Content(String type, ImageUrl imageUrl) {
        this.type = type;
        this.image_url = imageUrl;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class ImageUrl {
        public String image_url;
    }
}
