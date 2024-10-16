USE w3schools;

# 모든 레코드 삭제(!) 주의!!!
DELETE
FROM w3schools.Customers;

SELECT *
FROM w3schools.Customers
WHERE CustomerName = '흥민';

DELETE
FROM Customers
WHERE CustomerName = '흥민';

# 꼭 DELETE 실행 전 같은 WHERE 절로 SELECT 해볼 것!
SELECT *
FROM Customers
WHERE CustomerId = '한강';

DELETE
FROM Customers
WHERE CustomerName = '한강';

