package com.yzall.designbytes.controller;

import com.yzall.designbytes.dto.ResponseDTO;
import com.yzall.designbytes.dto.VideoDTO;
import com.yzall.designbytes.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/video")
@Tag(name = "VIDEO", description = "비디오 관련 API")
public class VideoController {
    VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @Operation(summary = "동영상 URL 로 저장", description = "유튜브등 URL을 받아서 저장.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "401", description = "로그인 정보 없는 사용자 TODO"),
            @ApiResponse(responseCode = "403", description = "인증되지 않은 접근 TODO"),
            @ApiResponse(responseCode = "409", description = "이미 존재하는 URL"),
            @ApiResponse(responseCode = "500", description = "백엔드 코드 에러"),
    })
    @PostMapping("/insert/url")
    public ResponseEntity<ResponseDTO> insertVideoUrl(@RequestBody VideoDTO videoDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            VideoDTO result = videoService.insertVideoUrl(videoDTO);
            responseDTO.setData(result);
            responseDTO.setMessage("영상 저장에 성공하였습니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            responseDTO.setMessage("해당 URL 은 이미 존재합니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "동영상 파일로 저장", description = "동영상 파일을 받아서 저장.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "401", description = "로그인 정보 없는 사용자 TODO"),
            @ApiResponse(responseCode = "403", description = "인증되지 않은 접근 TODO"),
            @ApiResponse(responseCode = "413", description = "영상 용량이 너무 큼"),
            @ApiResponse(responseCode = "500", description = "백엔드 코드 에러"),
    })
    @PostMapping("/insert/file")
    public ResponseEntity<ResponseDTO> insertVideoFile(@RequestBody VideoDTO videoDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            VideoDTO result = videoService.insertVideoFile(videoDTO);
            responseDTO.setData(result);
            responseDTO.setMessage("영상 저장에 성공하였습니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            responseDTO.setMessage("해당 URL 은 이미 존재합니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
