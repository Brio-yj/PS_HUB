select
    CAR_ID,
    case 
    when CAR_ID NOT IN(
        SELECT car_id	
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
        WHERE C.start_date <= "2022-10-16" and C.end_date >= "2022-10-16"
        ) 
    then "대여 가능"
    else "대여중"
    end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
order by CAR_ID DESC



/*
a->대여중
//대여중, 나머진 그냥 대여 가능, 어차피 NOT IN 하면 걸러진다


with a as(
SELECT car_id	
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
WHERE C.start_date <= "2022-10-16" and C.end_date >= "2022-10-16"
)
*/