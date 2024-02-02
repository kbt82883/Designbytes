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
    public String userName;

    @Column(name = "user_password")
    public String userPassword;

    @Column(name = "user_role")
    public Integer userRole;

    @Column(name = "use_yn")
    public char useYn;

    @Column(name = "insert_dt")
    public LocalDateTime insertDt;

    @Column(name = "insert_id")
    public String insertId;

    @Column(name = "update_dt")
    public LocalDateTime updateDt;

    @Column(name = "update_id")
    public String updateId;

    public UserDTO toDTO() {
        return new UserDTO(userNo, userId, userName, null, userRole, useYn, insertDt, insertId, updateDt, updateId);
    }
}
