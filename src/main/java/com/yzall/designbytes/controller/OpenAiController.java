package com.yzall.designbytes.controller;

import com.yzall.designbytes.dto.ResponseDTO;
import com.yzall.designbytes.dto.VisionDTO;
import com.yzall.designbytes.service.OpenAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "GPT VISION AI", description = "이미지 분석 관련 API")
public class OpenAiController {

    OpenAiService openAiService;

    @Autowired
    public OpenAiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @Operation(summary = "이미지 분석", description = "TODO 를 받아서 이미지 분석. 성공시 분석 데이터 반환. 실패시 메시지 반환.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "401", description = "로그인 정보 없는 사용자 TODO"),
            @ApiResponse(responseCode = "403", description = "인증되지 않은 접근 TODO"),
            @ApiResponse(responseCode = "423", description = "단기간내 너무 많은 요청 TODO"),
            @ApiResponse(responseCode = "500", description = "백엔드 코드 에러"),
    })
    @PostMapping("/openai/vision")
    public ResponseEntity<ResponseDTO> getVisionData(@RequestBody VisionDTO visionDTO) {

        // TODO 인증 처리

        ResponseDTO responseDTO = new ResponseDTO();
        try {

        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
