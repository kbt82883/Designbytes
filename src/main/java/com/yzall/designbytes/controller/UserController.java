package com.yzall.designbytes.controller;

import com.yzall.designbytes.dto.ResponseDTO;
import com.yzall.designbytes.dto.UserDTO;
import com.yzall.designbytes.service.UserService;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "User", description = "사용자 관련 API")
public class UserController {

    /**
     * TODO 기능 추가
     * 탈퇴, 로그아웃, 정보수정, 비밀번호 변경, 비밀번호 찾기, 아이디 찾기
     * TODO DB 수정
     * EMAIL, 폰번호, 토큰값
     */

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원가입", description = "userId, userName, userPassword 를 받아서 사용자를 생성.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "409", description = "해당 ID의 유저가 중복됨."),
            @ApiResponse(responseCode = "500", description = "백엔드 코드 에러"),
    })
    @PostMapping("/user/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            UserDTO result = userService.createUser(userDTO);
            responseDTO.setData(result);
            responseDTO.setMessage("사용자 생성에 성공하였습니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            responseDTO.setMessage("해당 ID는 이미 존재합니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "로그인", description = "userId, userPassword 를 받아서 로그인. 성공시 사용자 정보를 반환. 실패시 메시지 반환.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(schema = @Schema(implementation = ResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "ID 또는 암호가 다름. 또는 사용자가 존재하지 않음."),
            @ApiResponse(responseCode = "500", description = "백엔드 코드 에러"),
    })
    @PostMapping("/user/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            UserDTO result = userService.login(userDTO);
            if (result == null) {
                responseDTO.setMessage("ID 또는 암호가 다릅니다.");
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            }
            responseDTO.setData(result);
            responseDTO.setMessage("로그인에 성공하였습니다.");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
