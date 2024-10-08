USE w3schools;
# SELECT 컬럼명들.. FROM 테이블명 WHERE 조건

# 컬럼명 = '값'
SELECT FirstName, LastName, BirthDate
FROM Employees
WHERE BirthDate = '1963-08-30';

# >, <, >=, <=, !=
SELECT *
FROM Employees
WHERE BirthDate > '1963-08-30';

SELECT *
FROM Employees
WHERE BirthDate > '1963-08-30';

SELECT *
FROM Employees
WHERE BirthDate >= '1963-08-30';

SELECT *
FROM Employees
WHERE BirthDate <= '1963-08-30';

SELECT *
FROM Employees
WHERE BirthDate != '1963-08-30';

SELECT *
FROM Employees
WHERE BirthDate <> '1963-08-30'; # != 와 같음

SELECT *
FROM w3schools.Customers
WHERE CustomerID >= 80;

SELECT *
FROM w3schools.Customers
WHERE CustomerName = 'd';

SELECT *
FROM w3schools.Customers
WHERE CustomerName = 'D'; # ='d'

SELECT *
FROM w3schools.Customers
WHERE CustomerName < 'd';
# d보다 작은 사람들 a,b,c

# 1998-01-01(포함 , OrderDate) 이후에 주문되니 건들(Orders)
# 수량(Quantity) 이 10개 미만인 주문상세들(OrderDetails)
# 카테고리 번호가 1,2,3 번인 상품들

SELECT *
FROM Orders
WHERE OrderDate >= '1998-01-01';

