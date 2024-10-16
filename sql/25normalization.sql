USE db1;
SELECT *
FROM w3schools.Products;
DESC w3schools.Products;
DESC w3schools.Suppliers;
DESC w3schools.Categories;

SELECT *
FROM w3schools.Suppliers;

SELECT *
FROM w3schools.Categories;

# 상품
# 상품번호,상품명, 단위, 가격, 카테고리명, 카테고리설명,
# 공급자명, 계약명, 도시, 주소, 우편번호, 국가, 전화번호

#_______________________________________________________

#상품
#상품번호,상품명, 단위, 가격, 카테고리번호(FK), 공급자번호(FK)

# 카테고리
# 카테고리번호, 카테고리명, 카테고리설명

# 공급자
# 공급자번호, 공급자명, 계약명, 도시, 주소, 우편번호, 국가, 전화번호

USE w3schools;
ALTER TABLE w3schools.Products
    ADD CONSTRAINT FOREIGN KEY fk1 (CategoryID) REFERENCES Categories (CategoryID);
ALTER TABLE w3schools.Products
    ADD CONSTRAINT FOREIGN KEY fk2 (SupplierID) REFERENCES Suppliers (SupplierID);
