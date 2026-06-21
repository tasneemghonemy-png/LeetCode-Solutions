/* Write your PL/SQL query statement below */
select product_id as "product_id",
                   year as "first_year",
                    quantity as "quantity",
                    price as "price"
from sales s1
where year = (select  min(year)
              from sales s2
              where s1.product_id = s2.product_id );                 



