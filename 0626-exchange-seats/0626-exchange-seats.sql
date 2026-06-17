/* Write your PL/SQL query statement below */
with cte as(select id,
    nvl(lead(student,1) over(order by id),student) as nextt,
    lag(student,1) over(order by id) as prev
from seat )   


select id as "id", case when mod(id,2) = 1 then nextt
            else prev
            end as "student"
from cte;            
