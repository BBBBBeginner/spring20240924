<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>국가명 목록</h3>
<ul>
    <c:forEach items="${countryList}" var="country">
        <li>${country}</li>
    </c:forEach>
</ul>
</body>
</html>
