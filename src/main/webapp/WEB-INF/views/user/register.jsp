<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <div >
        <h3>오늘 하루를 기록해보세요.</h3>
        <h1> 한솔이의 일기장</h1>
    </div>
    <div class="register-container">
        <h2>회원가입</h2>
        <form action="/register" method="post">
            <div class="form-group">
                <input type="email" id="email" name="email" placeholder="email" >
            </div>
            <div class="form-group">
                <input type="text" id="nickName" name="nickName" placeholder="닉네임" >
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" placeholder="비밀번호" >
            </div>
            <div class="form-group">
                <button type="submit">회원가입하기</button>
            </div>
        </form>
    </div>
</body>
</html>