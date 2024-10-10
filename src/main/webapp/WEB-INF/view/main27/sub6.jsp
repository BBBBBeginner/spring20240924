<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <style>
        .active {
            background-color: yellow;
        }
    </style>
    <title>Title</title>
</head>
<body>
<h3>주문 목록 (페이징)</h3>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>고객id</th>
        <th>직원id</th>
        <th>주문일</th>
        <th>배송id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.customerId}</td>
            <td>${order.employeeId}</td>
            <td>${order.orderDate}</td>
            <td>${order.shipperId}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="margin: 10px;">
    <c:if test="${not empty prevPageNumber}">
        <c:url value="/main27/sub6" var="link">
            <c:param name="page" value="${prevPageNumber}"></c:param>
        </c:url>
        <a href="${link}">&lt; 이전</a>
    </c:if>
    <c:forEach begin="${beginPageNumber}" end="${endPageNumber}" var="pageNumber">
        <c:url value="/main27/sub6" var="link">
            <c:param name="page" value="${pageNumber}"></c:param>
        </c:url>
        <span class="${currentPageNumber == pageNumber ? 'active' : ''}">
            <a href="${link}">${pageNumber}</a>
        </span>
    </c:forEach>
    <c:if test="${not empty nextPageNumber}">
        <c:url value="/main27/sub6" var="link">
            <c:param name="page" value="${nextPageNumber}"></c:param>
        </c:url>
        <a href="${link}">다음 &gt;</a>
    </c:if>
</div>
</body>
</html>