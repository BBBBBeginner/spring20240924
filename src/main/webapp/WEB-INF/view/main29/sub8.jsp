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
<form action="/main29/sub7" method="post">
    <div>
        <input type="text" name="isbn" value="${param.isbn}">
        isbn
    </div>
    <div>
        <input type="text" name="title" value="${param.title}">
        title
    </div>
    <div>
        <input type="text" name="author" value="${param.author}">
        author
    </div>
    <div>
        <input type="number" name="price" value="${param.price}">
        price
    </div>
    <div>
        <input type="date" name="published" value="${param.published}">

        date
    </div>
    <div>
        <button>저장</button>
    </div>
</form>
</body>
</html>
