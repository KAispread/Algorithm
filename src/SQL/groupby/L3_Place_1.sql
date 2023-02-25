-- 헤비유저가 소유한 장소
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID
                  FROM PLACES P
                  GROUP BY HOST_ID
                  HAVING COUNT(*) >= 2)
ORDER BY ID;