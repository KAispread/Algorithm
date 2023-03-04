-- 입양 시각 구하기(2)
SET @h = -1;

SELECT (@h := @h + 1) as `HOUR`,
        (SELECT COUNT(*) FROM ANIMAL_OUTS
            WHERE HOUR(DATETIME) = `HOUR`) as COUNT
    FROM ANIMAL_OUTS
    WHERE @h < 23;