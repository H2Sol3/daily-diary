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
        <h2>일기장 목록</h2>

        <%-- 일기장 리스트 --%>
        <c:forEach items="${boardList}" var="list" varStatus="status">
            <div><hr>
                <h3>${list.title}</h3>
                <h5>${list.content}</h5>
                <h5>${list.date}</h5><hr>
            </div>
        </c:forEach>
        <input type = "button" value="글작성" onclick="location.href='/daily-list/diary'">
    </div>
</body>
</html>