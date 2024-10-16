SELECT 3;
SELECT 3 + 5;
SELECT 3 * 5;
SELECT 3 / 5;
SELECT 3 % 5;
# SELECT 'hello' || 'world';
SELECT CONCAT('hello', 'world');

USE w3schools;

SELECT LastName, FirstName
FROM Employees;

SELECT CONCAT(FirstName, ' ', LastName) full_name
FROM Employees;
SELECT CONCAT(Address, ' ', City, ' ', Country) full_address
FROM Customers;

# 1번 고객의 총 주문 금액
SELECT c.CustomerName, o.OrderDate, p.ProductName, od.Quantity, p.Price, (p.Price * od.Quantity) 소비금액
FROM Customers c
         JOIN Orders o
              ON c.CustomerID = o.CustomerID
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON od.ProductID = p.ProductID
WHERE c.CustomerID = 1;

SELECT c.CustomerName, sum(p.Price * od.Quantity) 총소비금액
FROM Customers c
         JOIN Orders o
              ON c.CustomerID = o.CustomerID
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON od.ProductID = p.ProductID
GROUP BY c.CustomerID;


# 1998년 3월에 가장 많은 매출을 올린 직원 조회
SELECT CONCAT(e.FirstName, ' ', e.LastName), o.OrderDate, SUM(p.Price * od.Quantity) AS sum
FROM OrderDetails od
         JOIN Products p
              ON p.ProductID = od.ProductID
         JOIN Orders o
              ON o.OrderID = od.OrderID
         JOIN Employees e
              ON e.EmployeeID = o.EmployeeID
WHERE o.OrderDate BETWEEN '1998-03-01' AND '1998-03-31'
GROUP BY e.FirstName
ORDER BY sum DESC
LIMIT 1;