USE w3schools;

# BETWEEN 값1 AND 값2 : 값1 과 값2 사이(값1 과 값2 사이 (값1,값2 포함)
# 열 >= 값 AND 열 <= 값2

SELECT *
FROM w3schools.Products
WHERE Price >= 10
  AND Price <= 20
ORDER BY Price;

SELECT *
FROM w3schools.Products
WHERE Price BETWEEN 10 AND 20;

# 열 IN (값1, 값2, 값3) : 값1이거나 값2이거나 값3이거나...
# 열 = 값1 OR 열 = 값2 OR 열 = 값3
SELECT *
FROM w3schools.Customers
WHERE Country = 'USA'
   OR Country = 'mexico'
ORDER BY Country, City;

SELECT *
FROM w3schools.Customers
WHERE Country IN ('USA', 'mexico', 'brazil')
ORDER BY Country, City;

# 1997년에 주문된 주문들
SELECT *
FROM Orders
WHERE OrderDate BETWEEN '1997_01_01' AND '1997_12_31';

# 미국이나 영국에 있는 공급자들
SELECT *
FROM Suppliers
WHERE Country IN ('UK', 'USA');

SELECT *
FROM Suppliers
WHERE Country = 'UK'
   OR Country = 'USA';

