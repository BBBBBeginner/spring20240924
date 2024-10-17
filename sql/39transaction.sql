USE db1;
CREATE TABLE my_table58
(
    name  VARCHAR(30),
    money INT
);

INSERT INTO my_table58
VALUES ('kim', 10000),
       ('lee', 10000);


# transection : 업무단위 SELECT 붙어 있음(모두 실패하거나, 모두 성공 해야함)
# kim -> lee 500원 송금
UPDATE my_table58
SET money = money - 500
WHERE name = 'kim';
UPDATE my_table58
SET money = money + 500
WHERE name = 'lee';

# transection
SELECT *
FROM my_table58;

COMMIT; # 반영 / 원래는 실행하면 동시에 db에 반영되는데 오토커밋을 끄면 수동으로 COMMIT 해야함
ROLLBACK;
# 전 커밋으로 되돌리기

#----------------------오토커밋 수동으로 바꿈----------------------------

# kim -> lee 500원 송금
UPDATE my_table58
SET money = money - 500
WHERE name = 'kim';

# 마지막 커밋으로 되돌리기
ROLLBACK;

UPDATE my_table58
SET money = money + 500
WHERE name = 'lee';

# 정상적으로 끝냈다 -> db에 반영 확정 , COMMIT
Commit;


# kim -> lee 1000원 송금
# 시나리오1) kim 계좌에서 1000원 차감되고 롤백
UPDATE my_table58
SET money = money - 1000
WHERE name = 'kim';
ROLLBACK;
# 시나리오2) kim 계좌에서 1000원 차람, lee 계좌에서 1000원 증액, 커밋
UPDATE my_table58
SET money = money - 1000
WHERE name = 'kim';
UPDATE my_table58
SET money = money + 1000
WHERE name = 'lee';
Commit;

SELECT *
FROM my_table58;