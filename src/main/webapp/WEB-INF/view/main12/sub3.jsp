<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- EL에서 사용 가능한 연산자 --%>
<%-- 산술 연산자 +, - ,*, /, % --%>
<p>${3 + 3}</p>  <!-- 결과: 6 -->
<p>${5 - 2}</p>  <!-- 결과: 3 -->
<p>${4 * 3}</p>  <!-- 결과: 12 -->
<p>${3 / 2}</p>  <!-- 결과: 1 (정수 나누기) -->
<p>${5 div 3}</p>  <!-- 결과: 1 (정수 나누기) -->
<p>${10 % 3}</p>  <!-- 결과: 1 -->
<p>${14 mod 5}</p>  <!-- 결과: 4 -->

<hr>
<p>${"3" + "3"}</p>  <!-- 결과: 33 (문자열 덧셈) -->

<%-- 아래 코드는 오류 발생: 문자열과 문자열을 더할 수 없습니다. --%>
<%-- <p>${"3" + "one"}</p>   안됨 --%>

<hr>

<%-- 변수 사용 예시: num1, num2, num3가 사전에 정의되어 있어야 함 --%>
<%-- 예를 들어, ${num1} = 6, ${num2} = 3, ${num3} = 2라 가정 --%>
<%-- <p>${num1 - num2}</p>  결과: 3 --%>
<%-- <p>${num1 / num3}</p>  결과: 3 --%>


<%-- 비교 연산자 ==, !=, < , >, <=, >= --%>
<p>${5 == 5}</p>  <!-- 결과: true -->
<p>${5 eq 5}</p>  <!-- 결과: true -->

<%-- 아래 코드는 오류 발생: '!=', 'ne'를 사용해야 함 --%>
<%-- <p>${5 =! 5}</p> --%>
<p>${5 != 5}</p>  <!-- 결과: false -->
<p>${5 ne 5}</p>  <!-- 결과: false -->

<p>${3 < 5}</p>  <!-- 결과: true -->
<p>${5 > 3}</p>  <!-- 결과: true -->
<p>${5 <= 5}</p>  <!-- 결과: true -->
<p>${5 >= 5}</p>  <!-- 결과: true -->

<%-- 비교 연산 시 주의: 다른 타입끼리 연산 시 수로 변환 후 비교 --%>
<p>${"12" < "6"}</p>  <!-- 결과: true (문자열 비교, 사전순 비교) -->
<p>${"ab" < "f"}</p>  <!-- 결과: true (문자열 비교) -->
<p>${12 < 6}</p>  <!-- 결과: false (숫자 비교) -->
<p>${"12" < 6}</p>  <!-- 결과: false (문자열을 숫자로 변환하여 비교) -->
<p>${12 < "6"}</p>  <!-- 결과: false (숫자를 문자열로 변환하여 비교) -->
<%-- <p>${12 < "six"}</p> --%>  <!-- 오류: 숫자가 아닌 문자열 비교는 안됨 -->


<%-- 논리연산자 &&, ||, !--%>
<p>${true && true}</p>
<p>${true and true}</p>

<p>${false || false}</p>
<p>${false or false}</p>

<p>${!true}</p>
<p>${not true}</p>

<hr>
<%--empty--%>
<%--"", 길이가 0인 콜렉션(List, Set, Map), null 이면 true--%>
<%-- 빈 문자열, 빈콜렉션, null이 아닌지 판단--%>
<p>${empty ""}</p> <%--true--%>
<p>${empty attr1}</p>
<p>${empty attr2}</p>
<p>${empty attr3}</p>
<p>${empty attr4}</p>
<p>${empty attr5}</p>
<p>${empty attr6}</p>


<p>${attr2.size() == 0}</p>
<p>${attr3.size() == 0}</p>
<p>${attr3.size() == 0}</p>
<p>${attr4.size() == 0}</p>

<hr>

<%-- 빈 문자열, 빈콜렉션, null이 아닌지 판단--%>
<p>${not empty ""}</p> <%--true--%>
<p>${not empty attr1}</p>
<p>${not empty attr2}</p>
<p>${not empty attr3}</p>
<p>${not empty attr4}</p>
<p>${not empty attr5}</p>
<p>${not empty attr6}</p>


<p>${attr2.size() == 0}</p>
<p>${attr3.size() == 0}</p>
<p>${attr3.size() == 0}</p>
<p>${attr4.size() == 0}</p>

<hr>
<%--삼항연산자 ? : --%>
<p>${true ? "hello" : "world"}</p>
<p>${false ? "hello" : "world"}</p>


</body>
</html>