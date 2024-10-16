USE db1;
DESCRIBE my_table29;

# 컬럼변경
ALTER TABLE my_table29
    MODIFY COLUMN name varchar(10) NOT NULL DEFAULT '0000' UNIQUE;
SELECT *
FROM my_table29;

# 컬럼 변경시 제약사항을 위반하는 기존 래코드의 값을 적절히 수정해야함
UPDATE my_table29
SET age = '1'
WHERE name = 's';

ALTER TABLE my_table29
    MODIFY COLUMN name VARCHAR(10) NOT NULL DEFAULT '0000' UNIQUE;

DESC my_table29;

# address 컬럼의 자료형 varchar(3)으로 변경
# not null 유지
ALTER TABLE my_table29
    MODIFY COLUMN country VARCHAR(30) NOT NULL;


# 컬럼 삭제
# 매우 주의
ALTER TABLE my_table29
    DROP COLUMN country;

# isbn, 제목, 저자, 가격, 출판일
# 테이블(book) 만들기
# Controller29, 7, 8번째 메소드 작성해서(jsp도)
# 새 책을 입력하는 프로그램 만들기

CREATE TABLE book
(
    isbn      VARCHAR(30),
    title     VARCHAR(30),
    author    VARCHAR(30),
    price     DEC(10, 5),
    published DATETIME

);

SELECT *
FROM book;
