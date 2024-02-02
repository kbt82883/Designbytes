package com.yzall.designbytes.repository.entity;

import com.yzall.designbytes.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Integer userNo;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_role")
    private Integer userRole;

    @Column(name = "use_yn")
    private char useYn;

    @Column(name = "insert_dt")
    private LocalDateTime insertDt;

    @Column(name = "insert_id")
    private String insertId;

    @Column(name = "update_dt")
    private LocalDateTime updateDt;

    @Column(name = "update_id")
    private String updateId;

    public UserDTO toDTO() {
        return new UserDTO(userNo, userId, userName, null, userRole, useYn, insertDt, insertId, updateDt, updateId);
    }
}
