<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${not empty message}">
    <h5 style="background-color: skyblue">${message}</h5>
</c:if>


<h3>직원 조회 후 수정</h3>
<form>
    직원번호 :
    <input type="number" name="id" value="${param.id}">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty employee}">
    <h5>조회된 결과가 없습니다.</h5>
</c:if>
<c:if test="${not empty employee}">
    <form action="/main28/sub12" method="post">
        <div>
            <span>번호</span>
            <input type="text" readonly name="id" value="${employee.id}">
        </div>
        <div>
            <span>퍼스트 네임</span>
            <input type="text" name="firstName" value="${employee.firstName}">
        </div>
        <div>
            <span>라스트 네임</span>
            <input type="text" name="lastName" value="${employee.lastName}">
        </div>
        <div>
            <span>생일</span>
            <input type="date" name="birthDate" value="${employee.birthDate}">
        </div>
        <div>
            <span>사진</span>
            <input type="text" name="photo" value="${employee.photo}">
        </div>
        <div>
            <span>노트</span>
            <textarea name="notes" id="" cols="30" rows="10">${employee.notes}</textarea>
        </div>
        <div>
            <button>저장</button>
        </div>
    </form>
</c:if>
</body>
</html>