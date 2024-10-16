USE w3schools;
DESC w3schools.Customers;

INSERT INTO Customers
    (CustomerID, CustomerName)
    VALUE (92, '흥민');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

INSERT INTO Customers
    (CustomerID, CustomerName, ContactName)
    VALUE (93, '강인', '미드필더');

INSERT INTO Customers
    (CustomerID, CUstomerName)
VALUES (94, '희찬'),
       (95, '희성'),
       (96, '타니');

INSERT INTO Customers
    (CustomerID, CustomerName)
    VALUE ('100', '근출'),
    ('98', '도널드'),
    ('99', '트럼프');

INSERT INTO Customers
    (CustomerName)
    VALUE ('지성');


# Customers 테이블에 2개의 레코드를 입력하기
INSERT INTO Categories
    (CategoryName, Description)
    VALUE ('Fastfood', 'hamberger, fried, pizza');
# Products 테이블에 2개의 레코드를 입력하기
INSERT INTO Products
    (ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
    VALUE (78, 'Seafood', 18, 3, '10 - 500 g pkgs.', 17.00),
    (79, 'rock', 18, 3, '10 - 500 g pkgs.', 17.00);


SELECT *
FROM Categories
ORDER BY CategoryID DESC;

SELECT *
FROM Products
ORDER BY Products.ProductID DESC;
