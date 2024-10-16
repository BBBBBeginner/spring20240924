<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <h5 style="background-color: aqua">${message}</h5>
</c:if>
<h3>상품 조회</h3>
<form>
    상품 번호 :
    <input type="number" name="id" value="${param.id}">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty product}" var="emptyProduct">
    조회된 상품이 없습니다.
</c:if>
<c:if test="${not emptyProduct}">
    <div>
        <span>번호</span>
        <input type="text" readonly="readonly" value="${product.id}">
    </div>
    <div>
        <span>상품명</span>
        <input type="text" readonly="readonly" value="${product.name}">
    </div>
    <div>
        <span>단위</span>
        <input type="text" readonly="readonly" value="${product.unit}">
    </div>
    <div>
        <span>가격</span>
        <input type="text" readonly="readonly" value="${product.price}">
    </div>
    <div>
        <span>카테고리</span>
        <input type="text" readonly="readonly" value="${product.categoryId}">
    </div>
    <div>
        <span>공급자</span>
        <input type="text" readonly="readonly" value="${product.supplierId}">
    </div>
    <div>
        <form action="/main28/sub8" method="post">
            <input type="hidden" name="id" value="${product.id}">
            <button>삭제</button>
        </form>
    </div>
</c:if>

</body>
</html>
