/* Write your PL/SQL query statement below */
with cte as(
    select buyer_id as buyer_id, count(order_id)as orders_in_201
    from Orders
    where order_date > '2018-12-31' and  order_date < '2020-01-01'
    group by buyer_id
)  

select  u.user_id as"buyer_id",
        to_char(u.join_date,'YYYY-MM-DD') as "join_date",
        nvl(c.orders_in_201,0)  as "orders_in_2019"
from users u
left join cte c     
on c.buyer_id = u.user_id;

 
