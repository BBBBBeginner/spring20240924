<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>기간별 주문 조회</h3>
<form>
    시작일
    <input type="date" name="begin" value="1996-07-04">
    <br>
    ~
    <br>
    종료일
    <input type="date" name="end" value="1998-05-06">
    <br>
    <button> 조회</button>
</form>
<hr>
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
</body>
</html>