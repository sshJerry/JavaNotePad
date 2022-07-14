create database <YOUR DATABASE>;

-- Create Table
use <YOUR DATABASE>;
create table employee(ID int primary key auto_increment, name varchar(50) not null, 
city varchar(50), salary double default 0);
describe employee;

-- Add Column departmentName to table
ALTER TABLE employee ADD COLUMN departmentName varchar(50) not null;
describe employee;

-- Inserting records in employee table
insert into employee(name, city, salary, departmentName) values('harry potter', 'london', 85000, 'HR');
insert into employee(name, city, salary, departmentName) values('Berry', 'manchester', 50000, 'IT');
insert into employee(name, city, salary, departmentName) values('Brand', 'LA', 50000, 'IT'), ('Von', 'LA', 50000, 'IT');
select * from employee;

-- Filter Using where clause
select name,city from employee where city = 'london';
select ID, name,salary from employee where salary >49000 AND departmentName = 'IT';
select name,salary from employee where salary BETWEEN 50000 AND 85000; /*50k and 85k are considered. Inclusive*/

-- Search for patterns using LIKE
-- Will Search for string : po. % operator indicates before and after chars
select name from employee where name LIKE '%po%';

-- display names that start with alphabet 'B'
select name from employee where name LIKE 'B%';

-- display names that end with alphabet
select name from employee where name LIKE '%r';

-- display the names that have 'e' as its second alphabet
select name from employee where name LIKE '_e%';
-- _ id ignore the character 


/*
Grouping Functions: count, min, max, avg, sum
*/
-- Count Number of employees in each department
select departmentName, count(ID) from employee group by departmentName;

-- Compute Max salary of employee from each department
select name,departmentName,max(salary) from employee group by departmentName;

-- Compute AVG salary of employee for each department having AVG salary great than 55000
/*
select name,departmentName,AVG(salary) from employee where salary >45000 group by departmentName;
This method of grouping last doesn't work. It doesn't accurately convey the data. 
I DONT WNT TO FILTER OUT OF SALARY INITALLY
*/
select departmentName,AVG(salary) from employee group by departmentName having AVG(salary)>45000;

-- Compute SUM of SALARIES of comployees for each department and display the result. Higher val first. At most 2 records
select departmentName,SUM(salary) as sum_sal from employee group by departmentName order by sum_sal DESC limit 1,3;

-- Offset
select * from employee limit 3,1;




CREATE TABLE IF NOT EXISTS `<YOUR DATABASE>`.`instructor` ( 

  `id` INT NOT NULL AUTO_INCREMENT, 

  `name` VARCHAR(45) NOT NULL, 

  `Instructorcol` VARCHAR(45) NULL, 

  `salary` DOUBLE NULL, 

  `city` VARCHAR(45) NULL, 

  PRIMARY KEY (`id`)) 

ENGINE = InnoDB; 
CREATE TABLE IF NOT EXISTS `<YOUR DATABASE>`.`department` ( 

  `id` INT NOT NULL AUTO_INCREMENT, 

  `name` VARCHAR(45) NOT NULL, 

  PRIMARY KEY (`id`)) 

ENGINE = InnoDB; 

CREATE TABLE IF NOT EXISTS `<YOUR DATABASE>`.`course` ( 

  `id` INT NOT NULL AUTO_INCREMENT, 

  `name` VARCHAR(45) NOT NULL, 

  `coursecol` VARCHAR(45) NULL, 

  `credits` INT NULL, 

  `department_id` INT NOT NULL, 

  PRIMARY KEY (`id`), 

  INDEX `fk_course_department_idx` (`department_id` ASC) VISIBLE, 

  CONSTRAINT `fk_course_department` 

    FOREIGN KEY (`department_id`) 

    REFERENCES `<YOUR DATABASE>`.`department` (`id`) 

    ON DELETE NO ACTION 

    ON UPDATE NO ACTION) 

ENGINE = InnoDB; 

CREATE TABLE IF NOT EXISTS `<YOUR DATABASE>`.`instructor_course` ( 

  `Instructor_id` INT NOT NULL, 

  `course_id` INT NOT NULL, 

  PRIMARY KEY (`Instructor_id`, `course_id`), 

  INDEX `fk_Instructor_has_course_course1_idx` (`course_id` ASC) VISIBLE, 

  INDEX `fk_Instructor_has_course_Instructor1_idx` (`Instructor_id` ASC) VISIBLE, 

  CONSTRAINT `fk_Instructor_has_course_Instructor1` 

    FOREIGN KEY (`Instructor_id`) 

    REFERENCES `<YOUR DATABASE>`.`instructor` (`id`) 

    ON DELETE NO ACTION 

    ON UPDATE NO ACTION, 

  CONSTRAINT `fk_Instructor_has_course_course1` 

    FOREIGN KEY (`course_id`) 

    REFERENCES `<YOUR DATABASE>`.`course` (`id`) 

    ON DELETE NO ACTION 

    ON UPDATE NO ACTION) 

ENGINE = InnoDB; 



describe instructor;
describe course;
describe department;
describe instructor_course;

insert into instructor (name,salary,city) values
('Stan K', 130000, 'Darian'),
('Mehi Q', 70000, 'Farmington'),
('King K', 60000, 'Beth');

select * from instructor;
delete from department;
insert into department (id,name) values (1, 'IT'), (2, 'ADMIN');

select * from department;

insert into course (name,credits,department_id) values
('JAVA', 100, 1),
('DBMS', 20, 2),
('Project M', 20, 2),
('Spring B', 120, 1);

select * from course;

insert into instructor_course(instructor_id, course_id) values
(1,1),(1,4),(2,3),(3,2),(3,1);
select * from instructor_course;

-- Display instructor details that are teaching 'java' course. MANUAL MAPPING QUERY
select instructor.id, instructor.name 
from instructor,instructor_course,course where instructor.id = instructor_course.instructor_id
AND instructor_course.course_id = course.id
AND course.name='JAVA';

select i.id, i.name 
from instructor as i,instructor_course as ic,course as c where i.id = ic.instructor_id
AND ic.course_id = c.id
AND c.name='JAVA';

-- Display the name(s) of department that employee id 1 is associated with.
/*MY IMPLEMENTATION*/
select i.id, i.name, d.id, d.name
from instructor as i,instructor_course as ic,course as c, department as d
where i.id=1 AND i.id=ic.instructor_id AND ic.instructor_id=ic.course_id AND ic.course_id=c.id;
/**/
select distinct d.name
from instructor as i,instructor_course as ic,course as c, department as d
where i.id = ic.instructor_id AND
ic.course_id = c.id AND
c.department_id = d.id AND
i.id =1;



/*
Nested Query / Sub Queries
*/
-- Display Instructor name teaching course JAVA - Use Nested Query Technique
select name
from instructor
where id = (select instructor_id
			from instructor_course
			where course_id = (select id
								from course
								where name='JAVA'));
/*
BREAKDOWN
select name
from instructor
where id = (select instructor_id
			from instructor_course
			where course_id = (1));
            
BREAKDOWN
select name
from instructor
where id = (1,3);
--THIS IS A TUPLE, THIS IS CF
*/

select name
from instructor
where id IN (select instructor_id
			from instructor_course
			where course_id IN (select id
								from course
								where name='JAVA'));
select name
from instructor
where id IN (1,3);
-- IN instead of = . How you do nested queries.


/* Display the names of instructors that are asscoaited with department 'IT'*/
-- MY IMPLEMENTATION
select name
from instructor
where id IN (select instructor_id
			from instructor_course
            where course_id IN(select id
								from course
								where department_id IN (select id
														from department
                                                        where name="IT")));


/*
	Joins:
		Inner Join
		Left Join
        Right Join
        *Technically Full Join but no dedicated keyword*
*/

-- Display Instructor name teaching course JAVA - Use Join Query Technique;
select * from instructor as i JOIN instructor_course as ic ON i.id = ic.instructor_id;

select * from instructor as i JOIN instructor_course as ic ON i.id = ic.instructor_id
JOIN course c ON ic.course_id =c.id
where c.name='JAVA';

-- Project course info along with dept info
select *
from course c JOIN department d ON c.department_id = d.id;

-- PROBLEM WITH JOIN
/* Apple Laptop doesn't have a vendor id to join with. Vendor with id 3 doesnt have a product to join with
If you don't have a vendorid, display null. Inner join will disregard datasets while LEFT JOIN will query correct*/
create table product (id int primary key auto_increment, name varchar(50), prince double, vendor_id int);
create table vendor (id int primary key auto_increment, name varchar(50));
insert into product (name, price, vendor_id) values
('HP Laptop', 1200, 1),
('Dell Laptop', 1100, 2),
('Lenovo Laptop', 1000, 2);
insert into vendor(name) values ('ABC Elec.'), ('PQR Elec.');

select * from product;
select * from vendor;

insert into product (name, price, vendor_id) values ('Apple Laptop', 1200);
insert into vendor(name) values ('XYZ Elec.');

-- Inner Join / Natural Join
select *from product p JOIN vendor v ON p.vendor_id = v.id;
-- Left Join / Left Out Join
select *from product p LEFT JOIN vendor v ON p.vendor_id = v.id;
-- Right Join / Right Outer Join
select *from product p RIGHT JOIN vendor v ON p.vendor_id = v.id;
/*DO NOT STUDY THIS BUT KNOW THAT IT EXISTS*/
select *from product p LEFT JOIN vendor v ON p.vendor_id = v.id
UNION
select *from product p RIGHT JOIN vendor v ON p.vendor_id = v.id;