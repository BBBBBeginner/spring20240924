USE w3schools;

# LIMIT : 조회결과 수(레코드 수, 행의 수)를 제한

SELECT *
FROM w3schools.Orders
ORDER BY OrderDate
LIMIT 10;


# 가장 비싼 상품 10개
SELECT *
FROM Products
WHERE Price
ORDER BY Price DESC
LIMIT 10;

# 3번 카테고리에서 가장 저렴한 상품 5개
SELECT *
FROM Products
WHERE Price
ORDER BY Price
LIMIT 5;

# 1번 고객이 가장 최근 주문한 주문
SELECT *
FROM Orders
WHERE CustomerID = 1
ORDER BY OrderDate DESC
LIMIT 1;

# LIMIT 수1 : 상위 (수1)개
# LIMIT 수1 , 수2 : (수1)번째부터 (수2)개, 단 수1은 0부터 시작
SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 3;

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 3,5;
/*3번 부터 5개*/
/*참고로 LIMIT의 1번 = 조회는 0번 부터 샘, 고로 4번쨰 부터 5개*/

#두번째로 나이 많은 직원
SELECT *
FROM Employees
ORDER BY BirthDate
LIMIT 2,1;


# 페이지를 나누기

#91명 고객
SELECT *
FROM Customers
ORDER BY CustomerID;

# 한 페이지에 10명 씩
# 1 페이지 1~10
SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 0, 10;
# 2 페이지 11~20
SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 10, 10;
# 3 페이지 21~30
SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 20, 10;


# 기존 데이터 복사해서 테이블에 추가하기
INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
SELECT CustomerName, ContactName, Address, City, PostalCode, Country
FROM Customers;
SELECT COUNT(*)
FROM Customers;