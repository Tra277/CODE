create database demoInsert;
use demoInsert;

create table Product(pid varchar(30) primary key,
pname nvarchar(100) not null, datecreate datetime default getdate(),
quantity int check(quantity > 0), price money check(price>0))

/**/

insert into Product values('P01','Iphone 15','5/25/2023',10,2000)

go select * from Product
--nhap thieu dataCreate
insert into Product values('P02','Iphone 16','8/25/2023',3000,1);
--sai vi tri
insert into Product values('P03','Iphone 16',1,'8/25/2023',3000)

/*
	insert into tableName(INputfields) values(listOfpara as INputfields)
	--khong can nhap: null,default
*/
insert into Product(pid,pname,datecreate,quantity,price)
values('P04','samsung','5/23/2023',10,1000)

--constrains
--primary key: no duplicate and not null
--duplicate 
insert into Product(pid,pname,datecreate,quantity,price)
values('P04','samsung','5/23/2023',10,1000)


--identity(1,1): auto number,start 1,step 1
create table Customer(cid int primary key identity(1,1),
fname nvarchar(30) not null, userName varchar(50) not null unique,
password varchar(32) check(len(password)>=8))

--Khong duoc insert vao identity
insert into Customer(fname,userName,password)
values ('Thanh tung','tung123','1234437823')

select * from Customer;

--foreign key constrain
create table Bill(billID varchar(50) primary key,
datecreate dateTime default getdate(),total money,
cid int foreign key references Customer(cid))
--foreign key constrain: gia tri khoa ngoai chi duoc phep nhap cac gia tri khoa chinh das ton tai

select * from Customer;
insert into Bill(billID,total,cid) values('bill01',1000,1)
select * from Bill

