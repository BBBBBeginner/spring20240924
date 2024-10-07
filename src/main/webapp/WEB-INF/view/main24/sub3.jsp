<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table style="border-collapse: collapse; width:100%;">
    <thead>
    <tr>
        <th>이름</th>
        <th>FirstName</th>
        <th>LastName</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${employeesList}" var="employees">
            <li>${employees.Id}</li>
            <li>${employees.First}</li>
            <li>${employees.Last}</li>
        </c:forEach>
    </tr>
    </tbody>
</table>
</body>
</html>
