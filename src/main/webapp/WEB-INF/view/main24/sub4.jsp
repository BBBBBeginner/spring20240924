<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
        }
    </style>
    <title>Title</title>
</head>
<body>
<h3>상품 목록</h3>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>상품명</th>
        <th>단위</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.unit}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>