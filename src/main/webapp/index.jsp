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
<form action="menuSelection" method="post">
    <%--@declare id="menu"--%><label for="menu">원하는 관리 메뉴의 번호를 입력해 주세요 :</label><br/>
    <input type="radio" id="menu1" name="menu" value="1">
    <label for="menu1">1. 강사 정보 관리</label><br/>
    <input type="radio" id="menu9" name="menu" value="9">
    <label for="menu9">9. 프로그램 종료</label><br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
