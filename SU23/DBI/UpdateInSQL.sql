

/* update Tablename set fieldName = value... [where conditions]*/

/*update all discontinued = 1*/
update Products set Discontinued = 1;

select * from Products

--update all discontinued = 0 if unitonOrder = 0
update Products set Discontinued = 0 where UnitsOnOrder = 0;
select * from Products

--unitPrice 
update Products set UnitPrice = UnitPrice *1.1, Discontinued = 1 
where UnitsInStock > 20 and UnitsOnOrder > 0

--Update primary key
select * from Territories
--Gia tri khoa chinh da ton tai tren khoa ngoai thi khong sua chua duoc khoa chinh
update Territories set TerritoryID='11111' where TerritoryID = '01581';
-- Tim khoa chinh khong ton tai tren khoa ngoai
select * from Territories
where TerritoryID not in (select distinct TerritoryID from EmployeeTerritories);

update Territories set TerritoryID = '11111' where TerritoryID='29202'

--update identity 
select * from Products
--
update Products set ProductID=1000 where ProductID = 1

/*
delete from tableName [where conditions]
where optinal, but don't have where --> delete all
in the case delete all, use :truncate table tableName 
*/

--truncate can chu y den foreign key constrain: gia tri khoa chinh da ton tai tren khoa ngoai, can xoa cac khoa ngoai
delete from Products
truncate table Products

select * from Territories
where TerritoryID not in (select distinct TerritoryID from EmployeeTerritories);

delete from Territories where TerritoryID = '11111'

delete from EmployeeTerritories where EmployeeID = 1 and TerritoryID = '06897'