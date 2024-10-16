<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <h5>${message}</h5>
</c:if>
<div>
    <input type="text" name="" value="${param.isbn}">
</div>
<div>
    <input type="text">
</div>
<div>
    <input type="text">
</div>
<div>
    <input type="text">
</div>
<div>
    <input type="text">
</div>
</body>
</html>
