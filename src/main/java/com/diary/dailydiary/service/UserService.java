package com.diary.dailydiary.service;

import com.diary.dailydiary.dto.UserDTO;

public interface UserService {
    UserDTO isEmailAlreadyRegistered(String email);//기존회원인지 확인

    void registerUser(UserDTO dto);//회원가입

    UserDTO getUserInfo(String email);
}
