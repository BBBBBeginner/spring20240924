USE db1;
# DEFAULT : 값을 넣지 않을 떄의 기본값
CREATE TABLE my_table24
(
    col1 VARCHAR(1),
    col2 VARCHAR(1) DEFAULT 'x'
);

SELECT *
FROM my_table24;

INSERT INTO my_table24
    (col2) VALUE ('a');
INSERT INTO my_table24
    (col1) VALUE ('a');

INSERT INTO my_table24
    (col1, col2) VALUE ('a', NULL);
DESC my_table24;


CREATE TABLE my_table25
(
    col1 INT NOT NULL UNIQUE DEFAULT 0
);

SELECT *
FROM my_table25;


# my_table26
# ssn, name, age, address

CREATE TABLE my_table26
(
    ssn     VARCHAR(25) UNIQUE NOT NULL,
    name    VARCHAR(20)        NOT NULL,
    age     INT DEFAULT 1,
    address VARCHAR(300)
);











