USE db1;
# full outer join : left join과 right join의 합집합
CREATE TABLE my_table56
(
    name VARCHAR(20),
    id   INT
);
CREATE TABLE my_table57
(
    email   VARCHAR(20),
    user_id INT
);
INSERT INTO my_table56
    (name, id)
VALUES ('kim', 1),
       ('lee', 2),
       ('park', 3),
       ('son', 4),
       ('han', 5);
INSERT INTO my_table57
    (email, user_id)
VALUES ('yaho', 3),
       ('gmail', 1),
       ('naver', 1),
       ('duck', 6),
       ('daum', 4);

# left join
SELECT *
FROM my_table56 t56
         LEFT JOIN my_table57 t57
                   ON t56.id = t57.user_id

UNION

SELECT *
FROM my_table55 t56
         RIGHT JOIN my_table57 t57
                    ON t56.id = t57.user_id;