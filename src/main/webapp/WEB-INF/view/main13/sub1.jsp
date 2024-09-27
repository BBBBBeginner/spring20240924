<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>main13/sub1.jsp</p>
<p>${attrt1}</p>
<%-- EL implicit objects--%>

<%-- 총 11개(아래사이트 참고)--%>
<%--https://www.javapoint.com/EL-expression-in-jsp--%>

<%--
param, paramValues,
pageScope, requestScope, sessionScope, applicationScope
--%>


<%--
param : request parameter을 map으로 담은 객체
--%>

<%--param 예시--%>
<%--?param = value&name=son&age=3--%>

<%--?name = 흥민&age=33--%>
<p>${param.name}</p> <%--흥민--%>
<p>${param.age}</p><%--33--%>


<%--?address=seoul&city=jeju--%>
<p>${param["address"]}</p>
<p>${param.city}</p>


<%-- 쿼리스트링 작성하고 요청 보내기--%>
<%--?email=naver&hobby=game$location=seoul--%>
<p>${param.email}</p>
<p>${param.hobby}</p>
<p>${param.score}</p>
<p>${param.location}</p>


<h5>paramValues</h5>
<%-- paramValues : request parameter의 값들을 배열로 map에 넣은 객체--%>
<%-- ?email=gmail&city=seoul --%>
<p>${param.email}</p>
<p>${paramValues.email[0]}</p>
<p>${param.city}</p>
<p>${paramValues.city[0]}</p>


<%--?hobby=축구&hobby=야구&hobby=농구&score=9.9&score=8.8--%>
<p>${paramValues.hobby[0]}</p><%--축구--%>
<p>${paramValues.hobby[1]}</p><%--야구--%>
<p>${paramValues.hobby[2]}</p><%--농구--%>
<p>${paramValues.score[0]}</p><%--9.9--%>
<p>${paramValues.score[1]}</p><%--8.8--%>


<p>${param.hoby}</p>
<p>${param.score}</p>


<%--쿼리스트링 작성후 요청 보내기--%>
<%--?player=오타니&player=흥민&player=범근&teams=다저스&teams=토트넘--%>
<p>${parmaValues.player[0]}</p>
<p>${parmaValues.player[1]}</p>
<p>${parmaValues.player[2]}</p>
<p>${parmaValues.teams[0]}</p>
<p>${parmaValues.teams[1]}</p>
</body>
</html>
