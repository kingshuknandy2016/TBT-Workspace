create database EmpDb;
use EmpDb;
create table Employee (
emp_id int primary key auto_increment,
emp_name varchar(15),
emp_dept varchar(10),	
emp_emailid varchar(15)
);
