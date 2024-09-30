<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--코드 작성 하기--%>
<c:set var="car" value="테슬라" scope="page"/>
<c:set var="car" value="기아" scope="request"/>
<c:set var="car" value="제네시스" scope="session"/>
<c:set var="car" value="삼성" scope="application"/>
<c:set var="car" value="삼성" scope="application"/>


<hr>
<p>${car}</p> <%--테슬라--%>
<p>${pageScope.car}</p> <%--테슬라--%>
<p>${requestScope.car}</p><%--기아--%>
<p>${sessionScope.car}</p><%--제네시스--%>
<p>${applicationScope.car}</p><%--삼성--%>


<hr>
<c:if test="true" var="someTest" scope="page">
</c:if>

<c:if test="${someTest}">
</c:if>

<p>${someTest}</p>
<p>${requestScope.someTest}</p>


<c:import url="sub19.jsp" var="sub19output">
    <p>${sub19output}</p>
</c:import>

</body>
</html>
