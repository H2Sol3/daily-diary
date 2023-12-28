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
        <h1> 한솔이의 일기장</h1>\
    </div>
    <div class="register-container">
    <form action="#">
        <table>
            <tr><td>${boardDTO.title}</td></tr>
            <tr><td>${boardDTO.content}</td></tr>
            <tr><td>${boardDTO.date}</td></tr>
        </table>
        <input type="submit" value="수정">
        <input type="button" id="deleteBtn" onclick="location.href='/diary/${boardDTO.boardSeq}'" value="삭제">
    </form>
    </div>
</body>
</html>