<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%--위의 것들을 지시자라고 함--%>
<%--contentType 속성 :HTML 문서로 출력하며, 문자 인코딩은 UTF-8로 설정한다는 뜻 --%>
<%--taglib 지시자 :  JSP에서 JSTL(Jakarta Standard Tag Library) 코어 태그를 사용할 때 접두사로 c를 사용하겠다 --%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<p>/main13/sub2</p>

<%--
JSTL : JSP Standard Tag Library

반복된 코드실행
출력 여부
--%>


<%--
if
--%>
<c:if test="false">
    <p>출력이 될까?</p>
</c:if>
<c:if test="${param.g == '남자'}">
    <p>남자입니다.</p>
</c:if>
<c:if test="${param.g == '여자'}">
    <p>여자입니다.</p>
</c:if>


<c:if test="${param.age<13}">
    <p>어린이용 컨텐츠</p>
</c:if>

<c:if test="${param.age && param.age < 20}">
    <p>청소년용 컨텐츠</p>
</c:if>

<c:if test="${param.age >= 20}">
    <p>성인용 컨텐츠</p>
</c:if>


<hr>
<%--request parameter 'country'의 값에 따라 다른 요소 출력--%>

<%--
country 가 uk이면
--%>
<c:if test="${param.country=='uk'}">
    <p>케인</p>
</c:if>
<%--
country 가 jp이면
--%>
<c:if test="${param.country=='jp'}">
    <p>오타니</p>
</c:if>
<%--
country 가 korea이면
--%>
<c:if test="${param.country=='korea'}">
    <p>손흥민</p>
</c:if>


</body>
</html>
