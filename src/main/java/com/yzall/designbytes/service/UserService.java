package com.yzall.designbytes.service;

import com.yzall.designbytes.dto.UserDTO;
import com.yzall.designbytes.repository.UserRepository;
import com.yzall.designbytes.repository.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 사용자 생성
     * @param userDTO
     * @return
     */
    @Transactional
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        // TODO length Validation
        // TODO secure coding
        // TODO Custom Exception
        try {
            String userId = userDTO.getUserId();
            String userName = userDTO.getUserName();
            String userPassword = userDTO.getUserPassword();

            if (userId == null || userId.isEmpty() || userName == null || userName.isEmpty() || userPassword == null || userPassword.isEmpty()) {
                throw new NullPointerException("필수값이 누락되었습니다.");
            }

            Integer userRole = 1;
            char useYn = 'Y';
            LocalDateTime insertDt = LocalDateTime.now();
            String insertId = "SYSTEM";

            Integer result = userRepository.insertUser(userId, userName, userPassword, userRole, useYn, insertDt, insertId);
            if (result != 1) {
                throw new Exception("사용자 생성에 실패하였습니다.");
            }
            return userDTO;
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("해당 ID는 이미 존재합니다.");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public UserDTO login(UserDTO userDTO) {
        try {
            String userId = userDTO.getUserId();
            String userPassword = userDTO.getUserPassword();
            User user = userRepository.findByUserIdAndUserPasswordAndUseYn(userId, userPassword, 'Y');
            if (user != null) {
                user.setUserPassword(null);
            }
            return user == null ? null : user.toDTO();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public UserDTO deleteUser(UserDTO userDTO) throws Exception {
        try {
            LocalDateTime nowDate = LocalDateTime.now();
            int result = userRepository.withDrawByUserNo(nowDate, 'N', nowDate, userDTO.getUserId(), userDTO.getUserNo());
            if (result != 1) {
                throw new Exception("사용자 삭제에 실패하였습니다.");
            }
            return userDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
