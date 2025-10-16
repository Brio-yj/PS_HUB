SELECT ORDER_ID,PRODUCT_ID,DATE_FORMAT(OUT_DATE,'%Y-%m-%d'),
CASE    
    WHEN OUT_DATE IS NULL THEN "출고미정"
    WHEN OUT_DATE > "2022-05-01" THEN "출고대기"
    ELSE "출고완료"
END AS 출고여부
FROM FOOD_ORDER 
ORDER BY ORDER_ID







/*
5/1 까지 나가면 출고완료
이후는 출고 대기
미정이면 출고 미정
*/