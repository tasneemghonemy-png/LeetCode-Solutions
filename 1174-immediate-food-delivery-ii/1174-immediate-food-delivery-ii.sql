/* Write your PL/SQL query statement below */
with  ordered_orders as(
    select order_date,
           customer_pref_delivery_date, 
            row_number() over(partition by customer_id order by order_date asc) as rnum
    from delivery
)

select round( 
                count(case when customer_pref_delivery_date = order_date then 1 end)*100.00 / 
                count(*)
            ,2) as "immediate_percentage"
from ordered_orders   
where rnum = 1;         