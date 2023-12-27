package com.diary.dailydiary.controller;

import com.diary.dailydiary.dto.UserDTO;
import com.diary.dailydiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    //메인 & 로그인 화면
    @GetMapping(path = "/")
    public String main(){

        return "user/loginForm";
    }

    //로그인
    @PostMapping()
    public String login(UserDTO userDTO){

        return "";
    }

    //로그아웃


    //회원가입 화면 리턴
    @GetMapping(path = "/register")
    public String register(){
        return "user/register";
    }



    @PostMapping(path = "/register")
    public String register(UserDTO dto){
        //동일한 이메일로 가입되어있는지 확인 필요
        UserDTO userDTO = userService.isEmailAlreadyRegistered(dto.getEmail());

        //없으면 회원가입
        if(userDTO == null){
            userService.registerUser(dto);
        }

        //있으면 가입불가


        return "user/loginForm";
    }



}
