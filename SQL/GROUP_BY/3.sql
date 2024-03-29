-- 입양 시각 구하기(1)
-- 시간만 추출 
-- MySQL : HOUR(DATETIME)
-- ORACLE : TO_CHAR(DATETIME, 'HH24')
SELECT TO_CHAR(DATETIME, 'HH24'), COUNT(TO_CHAR(DATETIME, 'HH24'))
FROM ANIMAL_OUTS
GROUP BY TO_CHAR(DATETIME, 'HH24')
HAVING TO_CHAR(DATETIME, 'HH24') BETWEEN 9 AND 19
ORDER BY TO_CHAR(DATETIME, 'HH24');
