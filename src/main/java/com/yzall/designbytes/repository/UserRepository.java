package com.yzall.designbytes.repository;

import com.yzall.designbytes.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNo(Integer userNo);

    User findByUserId(String userId);

    User findByUserIdAndUserPasswordAndUseYn(String userId, String userPassword, char useYn);

    @Modifying
    @Query(nativeQuery = true,
            value = "INSERT INTO user (user_id, user_name, user_password, user_role, use_yn, insert_dt, insert_id)" +
            "VALUES (:userId, :userName, :userPassword, :userRole, :useYn, :insertDt, :insertId)")
    Integer insertUser(String userId, String userName, String userPassword, Integer userRole, char useYn, LocalDateTime insertDt, String insertId);

    @Transactional
    @Modifying
    @Query("update User u set u.withdrawDt = ?1, u.useYn = ?2, u.updateDt = ?3, u.updateId = ?4 where u.userNo = ?5")
    int withDrawByUserNo(LocalDateTime withdrawDt, char useYn, LocalDateTime updateDt, String updateId, Integer userNo);

}
