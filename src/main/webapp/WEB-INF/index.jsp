<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instructor Management System</title>
</head>
<body>
<h1>====== Instructor Management System ======</h1>
<p>수능 인강 강사 관리 프로그램에 접속하셨습니다.</p>
<hr/>
<form method="POST" action="ApplicationServlet">
    <label for="menu">원하는 관리 메뉴의 번호를 선택해 주세요:</label><br>
    <select id="menu" name="menu">
        <option value="1">1. 강사 정보 관리</option>
        <option value="9">9. 프로그램 종료</option>
    </select>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
