<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>가격으로 상품명 조회</h3>
<form action="/main25/sub2" method="get">
    가격
    <input type="number" step="0.01" value="${param.price}" name="price">
    <button>조회</button>
</form>
<hr>
<c:if test="${not empty nameList}">
    <ul>
        <c:forEach items="${nameList}" var="name">
            <li>${name}</li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty nameList}">
    <b>해당 가격의 상품이 없습니다.</b>
</c:if>

</body>
</html>