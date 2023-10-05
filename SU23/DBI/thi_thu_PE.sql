--Q1
create table Manufacturers(
	ManufacturerID int primary key,
	ManufacturerAddress nvarchar(100),
	ManufacturerFax varchar(20),
	ManufacturerPhone varchar(20)
)

create table Laptops(
	LaptopID varchar(10) primary key,
	LaptopName nvarchar(50),
	Price decimal(8,2),
	[Description] nvarchar(500),
	ManufacturerID int foreign key references Manufacturers(ManufacturerID)
)

create table Customers(
	CustomerID int primary key,
	CustomerAddress nvarchar(100),
	CustomerPhone varchar(20)
)

create table Purchase(
	CustomerID int foreign key references Customers(CustomerID) ,
	LaptopID varchar(10) foreign key references Laptops(LaptopID),
	[Date] datetime,
	Quantity int,
	primary key(CustomerID,LaptopID)
)


--Q2
select e.employee_id,e.first_name,e.last_name from employees e
where e.employee_id < 105;
--Q3
select l.location_id,l.street_address,d.department_name,l.city from locations l
join departments d
on l.location_id = d.location_id
where d.department_name = 'IT' or d.department_name = 'Marketing';
--Q4
select (e.first_name+', '+e.last_name) as [full_name],j.job_title,d.department_name,e.salary from employees e
join jobs j
on j.job_id = e.job_id
join departments d
on d.department_id = e.department_id
where j.job_id = 16 and  e.salary > 7000
order by e.salary;
--Q5
select d.department_id,d.department_name,max(e.salary) as [Max(salary)] from departments d
join employees e
on d.department_id = e.department_id
group by d.department_id,d.department_name
order by max(e.salary) desc;

--Q6: cách xử lý là cứ thằng nào có employeeID trùng với managerID là được 
select top 5 e.first_name, e.last_name from employees e
where e.employee_id in (
select distinct manager_id from employees)
order by e.first_name
--Q7
select c.country_id,c.country_name,count(e.employee_id) as [number of employees] from countries c
join locations l
on c.country_id = l.country_id
join departments d
on l.location_id = d.location_id
join employees e
on d.department_id = e.department_id
group by c.country_id,c.country_name 
having count(e.employee_id) > 2
order by count(e.employee_id) desc;

--Q8
CREATE TRIGGER Salary_Not_Decrease
ON employees
AFTER UPDATE
AS
BEGIN
    IF EXISTS (SELECT 1 FROM inserted i JOIN deleted d ON i.employee_id = d.employee_id WHERE i.salary < d.salary)
    BEGIN
        RAISERROR ('Cannot decrease employee salary', 16, 1);
        ROLLBACK TRANSACTION;
    END
END;


--Q9 de y cai output
create procedure Get_ManagerID 
	@employeeID int,
	@managerID int output
as 
begin
	select @managerID = manager_id from employees
	where employee_id = @employeeID
end;

DECLARE @x INT;
DECLARE @in INT = 101;
EXECUTE Get_ManagerID @in, @x OUTPUT;
SELECT @x AS ManagerID;

--Q10
delete from dependents
where dependents.employee_id in (select d.employee_id from dependents d join employees e
on d.employee_id = e.employee_id where e.first_name = 'Karen')

