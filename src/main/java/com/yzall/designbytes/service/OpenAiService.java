package com.yzall.designbytes.service;

import com.yzall.designbytes.dto.VisionDTO;
import com.yzall.designbytes.dto.openai.ChatRequest;
import com.yzall.designbytes.dto.openai.ChatResponse;
import com.yzall.designbytes.dto.openai.Content;
import com.yzall.designbytes.dto.openai.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OpenAiService {

    Logger logger = LoggerFactory.getLogger(OpenAiService.class);

    WebClient webClient;

    @Value("${openai.api.key}")
    private String API_KEY;

    @Autowired
    public OpenAiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ChatResponse> getVisionData(VisionDTO visionDTO) throws Exception {
        try {
            // 1. 사용자 인증 여부 검사
            // TODO

            // 2. RPM 제한 검사
            // TODO

            // 3. Prompt 검증
            // TODO
            String prompt = visionDTO.getPrompt();

            // 4. 이미지 분석 요청
            // 4-1. 이미지 파일 첨부 여부 검사
            String imageUrl;
            if (visionDTO.getImageFile() != null) {
                // 4-2. 파일 있으면 BASE64 형식으로 변환
                // TODO
                imageUrl = "";
            } else {
                // 4-3. 파일 없으면 파일 URL 사용
                imageUrl = visionDTO.getImageUrl();
            }

            // 4-4. Request body 생성
            Message message = new Message();
            message.setRole("user");
            message.setContent(List.of(
                    new Content("text", prompt),
                    new Content("image_url", new Content.ImageUrl(imageUrl))
            ));
            ChatRequest chatRequest = new ChatRequest("gpt-4-vision-preview", List.of(message), 300);

            // 4-5. OpenAI API 호출
            webClient.post()
                    .header("Authorization", "Bearer" + API_KEY)
                    .body(Mono.just(chatRequest), ChatRequest.class)
                    .exchangeToMono(response -> {
                        HttpStatusCode httpStatusCode = response.statusCode();
                        return Mono.just(httpStatusCode);
                    }).subscribe(httpStatusCode -> {
                        if (httpStatusCode == HttpStatus.OK) {
                            logger.info("OPENAI :::: Success - status code : {}", httpStatusCode);
                            // TODO
                        } else {
                            logger.error("OPENAI :::: Failed - status code : {}", httpStatusCode);
                            // TODO
                        }
                    });








            // 5. 분석 결과 반환
        } catch (Exception e) {

        }

        return null;

    }
}
