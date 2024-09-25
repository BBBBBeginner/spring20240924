<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>${student[0]}</p>
<p>${student[1]}</p>
<p>${student[2]}</p>

<hr>
<p>${num}</p>
<p>${index}</p>
<p>${point}</p>

<hr>
<p>${students[num]}</p><%--${students[0}}--%>
<p>${students[index]}</p><%--${students["1"]}--%>
<p>${students[point]}</p><%--${students["2"]}--%>
</body>
</html>
