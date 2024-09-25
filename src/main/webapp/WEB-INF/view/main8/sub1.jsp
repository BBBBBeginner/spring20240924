<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Model에 있는 값 꺼내기</p>
<%
//  request.getAttribute("result1"); 자바코드로 쓸시
%>
<p>여러분이 검색한 결과 :</p>
<span style="color:blue";>

<p>${result}</p> //but html 형식으로 써도 알아서 자바식으로 바꿔서 해석

</span>
</body>
</html>
