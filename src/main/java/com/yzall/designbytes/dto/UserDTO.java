package com.yzall.designbytes.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Integer userNo;
    private String userId;
    private String userName;
    private String userPassword;
    private Integer userRole;
    private char useYn;
    private LocalDateTime insertDt;
    private String insertId;
    private LocalDateTime updateDt;
    private String updateId;
}
