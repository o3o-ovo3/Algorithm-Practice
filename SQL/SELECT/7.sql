-- 상위 n개 레코드
SELECT NAME 
FROM ANIMAL_INS
WHERE DATETIME = (
    SELECT MIN(DATETIME)
    FROM ANIMAL_INS
);
