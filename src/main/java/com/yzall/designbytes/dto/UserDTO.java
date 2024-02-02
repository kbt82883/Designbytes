package com.yzall.designbytes.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    public Integer userNo;
    public String userId;
    public String userName;
    public String userPassword;
    public Integer userRole;
    public char useYn;
    public LocalDateTime insertDt;
    public String insertId;
    public LocalDateTime updateDt;
    public String updateId;
}
