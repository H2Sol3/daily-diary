package com.diary.dailydiary.dao;

import com.diary.dailydiary.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    UserDTO isEmailAlreadyRegistered(String email);

    void registerUser(UserDTO dto);

    UserDTO getUserInfo(String email);
}
