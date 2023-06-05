<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Member List</title>
</head>
<body>
<h1>강사 목록 전체 조회</h1>
<table>
    <tr>
        <th>강사 코드</th>
        <th>강사 이름</th>
        <th>런칭일</th>
        <th>구분 코드</th>
        <th>과목 정보</th>
        <th>수강생 수</th>
        <th>연락처</th>
        <th>소속 코드</th>
        <th>활동 상태</th>
    </tr>
    <c:forEach items="${ requestScope.memberList }" var="member">
        <tr>
            <td>${ member.memberCode }</td>
            <td>${ member.memberName }</td>
            <td>${ member.launchDate }</td>
            <td>${ member.divisionCode }</td>
            <td>${ member.detailInfo }</td>
            <td>${ member.studentQuantity }</td>
            <td>${ member.contact }</td>
            <td>${ member.teamCode }</td>
            <td>${ member.activeStatus }</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
