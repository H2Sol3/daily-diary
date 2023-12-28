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
    <form action="<%=request.getContextPath()%>/daily-list/diary" method="post" encType="multipart/form-data">
        <table>
            <tr><td><h2>일기 작성</h2>
            <tr><td><input type="text" placeholder="제목을 입력하세요." name="title"></td>
                <td><input type="button" value="취소"></td>
                <td><input type="submit" value="작성"></td></tr>

            <tr><td><textarea rows="20" cols="70" placeholder=" 내용을 입력하세요." name="content" id="content"></textarea></td></tr>
            <tr><td><label for="file">첨부파일</label>
            <input type="file" class="form-control-file" id="file" name="file"></td></tr>
        </table>
    </form>
    </div>
</body>
</html>