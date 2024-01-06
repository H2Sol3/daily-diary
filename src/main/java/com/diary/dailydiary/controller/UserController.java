package com.diary.dailydiary.controller;

import com.diary.dailydiary.dto.UserDTO;
import com.diary.dailydiary.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    @PostMapping(path = "/login")
    public String login(UserDTO userDTO, HttpSession session){
        System.out.println(userDTO.getEmail());
        //아이디 비밀번호 불러오기
        UserDTO dbUser = userService.getUserInfo(userDTO.getEmail());
        //System.out.println(dbUser.getEmail()+dbUser.getPassword()+dbUser.getNickName());

        //회원이 아닐때
        if(dbUser == null){
            return "notUser";
        }

        if (dbUser.getPassword().equals(userDTO.getPassword())) {
            // 로그인 성공
            session.setAttribute("user", dbUser);
            return "success"; // 로그인 성공 시 이동할 페이지 설정
        } else {
            // 로그인 실패
            // 처리 로직 추가 (예: 에러 메시지 설정)
            return "null";
        }
    }

    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션을 무효화하여 로그아웃 처리
        session.invalidate();

        // 로그아웃 후 리다이렉트할 경로를 지정할 수 있습니다.
        return "redirect:/";
    }

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
            // 비밀번호 암호화
        //    String encodedPassword = PasswordEncoder.encode(dto.getPassword());
            userService.registerUser(dto);
        }

        //있으면 가입불가


        return "user/loginForm";
    }



}
