-- 그룹별 조건에 맞는 식당 목록 출력하기
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, date_format(R.REVIEW_DATE, '%Y-%m-%d') as 'REVIEW_DATE'
    FROM REST_REVIEW R
    JOIN MEMBER_PROFILE M ON R.MEMBER_ID = M.MEMBER_ID
    WHERE R.MEMBER_ID = (SELECT MEMBER_ID
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                        ORDER BY COUNT(*) DESC
                        LIMIT 1)
    ORDER BY R.REVIEW_DATE ASC, R.REVIEW_TEXT ASC;
