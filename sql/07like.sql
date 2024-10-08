USE w3schools;


#LIKE '대상' 이 포함되면 조회
SELECT *
FROM Customers
WHERE CustomerName LIKE '%ed';


SELECT *
FROM Customers
WHERE CUstomerName LIKE '%A';

# _ : 임의의 한글자
SELECT *
FROM Employees
WHERE BirthDate LIKE '195_-__-__';


# 고객명에 OR 이 포함되어 있는 고객들 조회
SELECT *
FROM Customers
WHERE CustomerName LIKE '%OR%';


# 고객계약명이 A로 시작하고 O로 끝나는 고객들 조회
SELECT *
FROM Customers
WHERE ContactName LIKE 'A%O'
