<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${jobs}</p>
<p>${jobs[0]}</p>
<p>${jobs[1]}</p>
<p>${jobs[2]}</p>
<p>${pointList[0]}</p>
<%--<p>${points}</p> name은 pointList로 선언 point는 value --%>


<hr>
<c:forEach items = "${jobs}" var="job">
  <p>${job}</p>
</c:forEach>

<hr>
<c:forEach items = "${pointList}" var="job">
  <p>${pointList}</p>
</c:forEach>
</body>
</html>
