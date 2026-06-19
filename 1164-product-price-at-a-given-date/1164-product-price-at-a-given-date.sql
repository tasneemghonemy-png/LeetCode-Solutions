/* Write your PL/SQL query statement below */
with cte as (
    select product_id as product_id,
            new_price as new_price, 
            change_date as change_date,
            row_number() over(partition by product_id order by change_date desc) as rwnum
    from products
    where change_date <= '2019-8-16'
)

select distinct p.product_id as "product_id",
       nvl(c.new_price,10) as "price"
from products p
left join cte c        
on c.product_id = p.product_id 
and rwnum = 1;