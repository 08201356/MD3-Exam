create database department_employee;
use department_employee;
create table department(
 deId int primary key,
 deName varchar(30),
 deDes	varchar(100)
 );
create table employee(
 emId int primary key,
 emName varchar(50),
 email varchar(50),
 address varchar(50),
 phoneNumber int,
 salary int,
 department varchar(50),
 foreign key(department) references department(deName)
 );
 