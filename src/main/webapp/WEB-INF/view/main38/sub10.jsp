<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>직원 정보 수정</h3>
<c:if test="${empty employee}">
    <h5>직원을 조회해 주세요.</h5>
</c:if>
<c:if test="${not empty employee}">

    <form action="/main38/sub10" method="post">
        <div>
            직원번호
            <input type="text" name="id" value="${employee.id}">
        </div>
        <div>
            이름
            <input type="text" name="firstName" value="${employee.firstName}">
        </div>
        <div>
            성
            <input type="text" name="lastName" value="${employee.lastName}">
        </div>
        <div>
            생일
            <input type="date" name="birthDate" value="${employee.birthDate}">
        </div>
        <div>
            사진
            <input type="text" name="photo" value="${employee.photo}">
        </div>
        <div>
            설명
            <textarea name="notes" id="" cols="30" rows="10">${employee.notes}</textarea>
        </div>
        <div>
            <button>저장</button>
        </div>
    </form>
</c:if>

</body>
</html>