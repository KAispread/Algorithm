-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
SELECT MONTH(C.START_DATE) as `MONTH`, C.CAR_ID, COUNT(*) as RECORDS
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C
    JOIN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
            GROUP BY CAR_ID
            HAVING COUNT(*) >= 5) AS T
        ON T.CAR_ID = C.CAR_ID
    WHERE C.START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY MONTH, CAR_ID
    ORDER BY MONTH, CAR_ID DESC