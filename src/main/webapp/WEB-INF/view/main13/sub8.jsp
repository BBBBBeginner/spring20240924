<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${datas}" var="data">
    <c:forEach items="${data}" var="entry">
        <div style="margin: 30px">
            <p>${entry.key}</p>
            <p>${entry.value}</p>
        </div>
    </c:forEach>
</c:forEach>

<hr>

<c:forEach items="${players}" var="player">
    <c:forEach items="${player}" var="socer">
        <p>${socer.key}:${socer.value}</p>
    </c:forEach>
</c:forEach>


</body>
</html>
