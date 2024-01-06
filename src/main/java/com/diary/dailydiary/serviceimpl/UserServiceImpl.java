package com.diary.dailydiary.serviceimpl;

import com.diary.dailydiary.dao.UserDAO;
import com.diary.dailydiary.dto.UserDTO;
import com.diary.dailydiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;


    @Override
    public UserDTO isEmailAlreadyRegistered(String email) {
        return userDAO.isEmailAlreadyRegistered(email);
    }

    @Override
    public void registerUser(UserDTO dto) {
        userDAO.registerUser(dto);
    }

    @Override
    public UserDTO getUserInfo(String email) {
        return userDAO.getUserInfo(email);
    }
}
