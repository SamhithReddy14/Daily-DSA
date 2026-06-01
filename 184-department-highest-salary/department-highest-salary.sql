# Write your MySQL query statement below
select d.name as Department , e.name as Employee , e.salary as Salary
from Employee e 
join Department d on e.departmentId = d.id 
where e.salary = (select max(e1.salary) from employee e1 where e1.departmentId = d.id);