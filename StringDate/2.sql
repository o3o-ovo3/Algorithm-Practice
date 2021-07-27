-- 이름에 el이 들어가는 동물 찾기
-- 대소문자 구분 없이 --> upper() 또는 lower()
-- 특정 문자열 포함 --> like '%%' 사용
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog' AND lower(NAME) LIKE '%el%' 
ORDER BY NAME ASC;
