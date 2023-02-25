-- 없어진 기록 찾기
SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS as I
         RIGHT JOIN ANIMAL_OUTS as O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.ANIMAL_ID IS NULL
ORDER BY O.ANIMAL_ID;