<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>dailydiary 메인화면</title>

</head>
<body>
    <div >
        <h3>오늘 하루를 기록해보세요.</h3>
        <h1> 한솔이의 일기장 </h1>
    </div>
    <div class="login-container">
        <h2>로그인</h2>
        <form action="/login" method="post">
            <div class="form-group">
                <input type="text" id="username" name="username" placeholder="email" >
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" placeholder="비밀번호" >
            </div>
            <div class="form-group">
                <button type="submit">로그인</button>
                <button type="#">구글 로그인</button>
                <h3>또는</h3>
            </div>
        </form>

            <input type="hidden" name="userSeq" value = 1>
            <button onclick="location.href='/register'">회원가입</button>
            <button onclick="location.href='/diary/1'">일기장 임시버튼</button>
    </div>
</body>
</html>