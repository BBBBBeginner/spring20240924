#data 들이 table 안에 저장됨

# table 들은 database(schema) 내에 저장됨

# database(schema) 만들기
CREATE DATABASE test1;

# table 만들기
CREATE TABLE book
(
    title varchar(100),
    price int
);

# database(schema) 이동
USE test1;
USE w3schools;


# table 지우기
DROP DATABASE test1;
DROP TABLE book;

# SELECT : 테이블 조회
# FROM 에 테이블명
# SELECT 에 컬럼명
SELECT *
FROM Customers;

# 모든 행은 같은 열을 가지고 있음

# 특정 컬럼만 조회
# SELECT 컬럼명 FROM 테이블명
SELECT CustomerID
FROM Customers;

SELECT CustomerID, CustomerName
FROM Customers;

# DESCRIBE 테이블명 : 테이블 구조 확인
DESCRIBE Customers;
DESC Customers;
#DESCRIBE와 같음

#Employees 테이블에 어떤 컬럼(필드)가 있는 지 확인하기
DESCRIBE Employees;

# Employees 테이블의 레코드의 EmplyeeID, LastName, FirstName 컬럼만 조회하기
SELECT EmployeeID, LastName, FirstName
FROM Employees;


# SELECT 에 작성된 컬럼 순서가 유지됨
SELECT FirstName, LastName
From Employees;


# * : 모든 컬럼
SELECT *
FROM Employees;

# Products 테이블의 모든 컬럼과 모든 행 조회
# Products 테이블의 ProductName, Unit, Price 컬럼 조회
# Suppliers 테이블의 City, Country, SupplierName 컬럼 조회(열순서유지)

DESC Products;

SELECT ProductName, Unit, Price
FROM Products;

SELECT City, Country, SupplierName
FROM Suppliers;

SELECT FirstName
FROM Employees;




