USE db1;
DESC my_table16;

#Constraints (제약사항)

# NULL 허용 여부
CREATE TABLE my_table17
(
    col1 VARCHAR(3),         -- NULL 허용, 값이 없어도 됨
    col2 VARCHAR(3) NOT NULL -- NULL 허용 안함, 값 무조건 존재해야 함
);

INSERT INTO my_table17
    (col2) VALUE ('어떤값');

INSERT INTO my_table17
    (col1) VALUE ('어떤값');

# 명시적 NULL
INSERT INTO my_table17
    (col1, col2) VALUE (NULL, '또다른');
INSERT INTO my_table17
    VALUE (NULL, 'abc');
INSERT INTO my_table17
    VALUE ('', '');
INSERT INTO my_table17
    VALUE (NULL, NULL);


DESC my_table17;

# my_table17 생성
# name (문자열) , price(정수)
# name은 꼭 값이 있어야 함


CREATE TABLE my_table18
(
    name  VARCHAR(100) NOT NULL,
    price INT
);





