<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instructor Information Management</title>
</head>
<body>
<h1>Instructor Information Management</h1>
<p>인강 강사의 정보 관리 화면입니다.</p>
<form method="POST" action="InstructorManagementServlet">
    <label for="menu">원하는 관리 메뉴의 번호를 입력해 주세요:</label><br>
    <select id="menu" name="menu">
        <option value="1">1. 전체 강사 정보 조회</option>
        <option value="2">2. 조건부 강사 정보 조회</option>
        <option value="3">3. 신규 강사 정보 등록</option>
        <option value="4">4. 기존 강사 정보 수정</option>
        <option value="5">5. 인기없는 단종 강사 삭제</option>
        <option value="9">9. 이전 메뉴로 이동</option>
    </select>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

