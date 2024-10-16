# 집계함수(Aggregate Functions)
# COUNT, AVG, SUM, MAX, MIN
# 집계함수 사용 시 NULL 포함되지 않음
DROP DATABASE w3schools;
CREATE DATABASE w3schools;
USE w3schools;

# COUNT 갯수
SELECT COUNT(*)
FROM Customers;
SELECT COUNT(CustomerID)
FROM Customers;
SELECT COUNT(ContactName)
FROM Customers;
INSERT INTO Customers
    (CustomerName)
VALUES ('흥민');

SELECT COUNT(Country)
FROM Customers;
SELECT COUNT(DISTINCT Country)
FROM Customers;

SELECT SUM(Price)
FROM Products;

SELECT AVG(Price)
FROM Products;

SELECT MAX(Price)
FROM Products;

SELECT MIN(Price)
FROM Products;


# GROUP BY : 소계시 사용
SELECT Country, COUNT(CustomerID) 인원
FROM Customers
GROUP BY Country
ORDER BY 인원 DESC
LIMIT 5;


# 카테고리별 평균 상품 가격
SELECT CategoryID, AVG(Price) 가격
FROM Products
GROUP BY CategoryID; /*CategoryID 내의 내용별로 나눠서, GROUP BY : ~ 로 나눠서*/

SELECT AVG(Price)
FROM Products p
         JOIN Categories c
              ON p.CategoryID = c.CategoryID
GROUP BY c.CategoryID;

# 직원별 주문처리건수(Employees, Orders)
# 직원의 이름과 처리건수 조회, 직원 first name 순 정렬
SELECT e.FirstName, e.LastName, COUNT(o.OrderID) 처리건수
FROM Orders o
         JOIN Employees e
              ON o.EmployeeID = e.EmployeeID
GROUP BY e.EmployeeID
ORDER BY e.FirstName;

# 고객별 주문 건수(주문하지 않은 고객도 포함)
SELECT c.CustomerID, c.CustomerName, COUNT(o.OrderID)
FROM Orders o
         JOIN Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 3 DESC;

# 한번도 주문하지 않은 고객
SELECT c.CustomerID, c.CustomerName, COUNT(o.OrderID)
FROM Customers c
         JOIN Orders o
              ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;

# 1997년 1월에 주문 처리건수를 직원별로 조회
SELECT o.OrderDate, o.EmployeeID, COUNT(o.OrderID)
FROM Customers c
         JOIN Orders o
              ON c.CustomerID = o.CustomerID
WHERE o.OrderDate BETWEEN '1997-01-01' AND '1997-01-31'
GROUP BY o.EmployeeID
ORDER BY o.OrderDate;

#-------- 주문처리건수가 없는 직원들만 조회(후에 더 배움 , AS)
SELECT COUNT(OrderID)
FROM (SELECT *
      FROM Orders
      WHERE OrderDate BETWEEN '1997-01-01' AND '1997-01-31') AS JanOrders
         JOIN Employees e
              ON JanOrders.EmployeeID = e.EmployeeID
GROUP BY e.EmployeeID
ORDER BY e.EmployeeID;

#--------- 프로그래머스 고양이
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;