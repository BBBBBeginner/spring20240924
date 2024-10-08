USE w3schools;

SELECT *
FROM Products;
# 항목 오름차순, 내림차순으로 조회
# ORDER BY : 조회 결과의 순서를 결정 만약 행안의 열 데이터 내용을 A,B,C 순으로 정리
# ORDER BY  컬럼명

SELECT *
FROM w3schools.Products
ORDER BY Price;
SELECT *
FROM w3schools.Employees
ORDER BY BirthDate;
SELECT *
FROM w3schools.Customers
ORDER BY CustomerName;

SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY Price;

#역 차순
SELECT *
FROM Products
ORDER BY Price DESC;


# 멕시코에 있는 고객 조회(이름 역순)
# 주문번호(OrderID)가 10248인 주문상세를 수량이 적은 것 부터 조회
# 공급자 번호 (SupplierID)가 1번인 상품(Products)을 이름(ProductName) 순으로 조회

SELECT *
FROM Customers
ORDER BY Country = 'mexico';

SELECT *
FROM OrderDetails
WHERE OrderID = 10248
ORDER BY Quantity DESC;

#ORDER BY 컬럼, 컬럼, 컬럼 : 여러 컬럼 기준으로 정렬
SELECT Customers.CustomerName, City, Customers.Country
FROM Customers
ORDER BY Country, City;

# 1번 카테고리 상품 조회 공급자순, 가격이 비싼순
SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY Price DESC, SupplierID;

# 컬럼명 대신 컬럼 인덱스 사용 가능
SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY 3, 6 DESC;


SELECT ProductID, ProductName, SupplierID, CategoryID, Unit, Price
FROM Products
WHERE CategoryID = 1
ORDER BY 3, 6 DESC; # 3번째 SupplierID 정렬, 6 오름차순으로 정렬


