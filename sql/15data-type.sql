USE db1;

# 데이터 타입
# 문자형
#    가변형
# 숫자형
#    정수
#    실수
# 날짜형
#    년월일
#    년월일시분초


# 지금 이것만 쓴다 뿐이지, 메뉴얼보면  이 외에도 굉장히 많음


# 문자형
# VARCHAR(길이)

CREATE TABLE my_table4
(
    col1 VARCHAR(2),
    col2 VARCHAR(3),
    col3 VARCHAR(5)
);
INSERT INTO my_table4
    (col1, col2, col3)
    VALUE ('a', 'b', 'c');


INSERT INTO my_table4
    (col1, col2, col3)
    VALUE ('abc', 'abc', 'abc');

INSERT INTO my_table4
    (col1, col2, col3)
    VALUE ('흥민', '손흥민', '서울특별시');


SELECT *
FROM my_table4;


CREATE TABLE my_table5
(
    title  VARCHAR(300), # VARCHAR(열 요소 하나당 문자의 길의 정의)
    author VARCHAR(100)
);

# my_table6 만들기
# 4개의 컬럼
# 각 컬럼의 데이터타입은 문자열 이고
# 컬럼명과, 허용되는 문자열 길이는 스스로 정해보기

CREATE TABLE my_table6
(
    first_column  VARCHAR(300),
    second_column VARCHAR(200),
    third_column  VARCHAR(100),
    fourth_column VARCHAR(100)
);

INSERT INTO my_table6
    (first_column, second_column, third_column, fourth_column)
    VALUE ('날두', '메시', '강인', '흥민');



# INT, INTEGER
# -2147483648 ~ 2147483647
CREATE TABLE my_table8
(
    price INT # 더 넓은 상수의 범위를 넣고 싶다 BIGINT
);

INSERT INTO my_table8
    (price) VALUE (1000);
INSERT INTO my_table8
    (price) VALUE ('2000');
INSERT INTO my_table8
    (price) VALUE ('천원');
INSERT INTO my_table8
    (price) VALUE (50.12);

SELECT *
FROM my_table8;

# DEC, DECIMAL
# 고정된 실수형
CREATE TABLE my_table9
(
    col1 DEC(3, 1),
    col2 DEC(5, 1)
);

INSERT INTO my_table9
    (col1) VALUE (31.4);
INSERT INTO my_table9
    (col1) VALUE (3.14); # 잘림
INSERT INTO my_table9
    (col1) VALUE (314.1); #

SELECT *
FROM my_table9;

# my_table10 만들기
# price, score, age, length, width, height

CREATE TABLE my_table10
(
    price  DEC(5, 2),
    score  INT,
    age    INT,
    length DEC(5, 2),
    width  DEC(5, 2),
    height DEC(5, 2)
);

INSERT INTO my_table10
    (price) Value (22.2);
INSERT INTO my_table10
    (score) Value (1);
INSERT INTO my_table10
    (age) Value (1);
INSERT INTO my_table10
    (length) Value (22.2);
INSERT INTO my_table10
    (width) Value (22.2);


# 날짜
# DATE 년월일
# YYYY-MM-DD

CREATE TABLE my_table11
(
    col1 DATE
);

INSERT INTO my_table11
    (col1) VALUE ('2024-02-14');
INSERT INTO my_table11
    (col1) VALUE ('1000-01-01');
INSERT INTO my_table11
    (col1) VALUE ('9999-12-31');

SELECT *
FROM my_table11;

# DATETIME : 날짜시간
# 'YYYY-MM-DD HH:MM:SS.fffff'

CREATE TABLE my_table12
(
    col1 DATETIME
);

INSERT INTO my_table12
    (col1) VALUE ('2024-10-24 10:35:08');
INSERT INTO my_table12
    (col1) VALUE ('2024-10-24 10:35:08');
INSERT INTO my_table12
    (col1) VALUE ('2024-10-24 10:35:08.12345');

SELECT *
FROM my_table12;

CREATE TABLE my_table13
(
    col1 DATETIME(6)
);

INSERT INTO my_table13
    (col1) VALUE ('2024-10-14 10:35:08.1234567');

SELECT *
FROM my_table13;


# my_table14
# birth_date, start_date_time, end_date_time

DROP TABLE my_table14;

CREATE TABLE my_table14
(
    birth_date      DATE,
    start_date_time DATETIME,
    end_date_time   DATETIME(6)
);

# 다른 스키마(데이터베이스)에 있는 테이블 사용하기
SELECT*
FROM w3schools.Products;

USE w3schools;
SELECT *
FROM db1.my_table11;



USE db1;
CREATE TABLE my_table15
(
    col1 VARCHAR(300),
    col2 INT,
    col3 DEC(15, 2),
    col4 DATE,
    col5 DATETIME
);

SELECT *
FROM my_table15;


CREATE TABLE my_table16
(
    title     VARCHAR(300),
    price     DEC(15, 5),
    score     INT,
    published DATE,
    inserted  DATETIME
);

SELECT *
FROM my_table16;

