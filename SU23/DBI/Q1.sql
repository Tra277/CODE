--create database dbname
create database SE1760
go
--change available db:use dbName
use SE1760
--create table name(fieldName dataType[(maxsize)][constrains],...)
--maxsize: áp dụng cho kiểu String
--dataType:
--int:4 byte
--float,double:8 byte
--real:4 byte
--money:8 byte
--small money:4 btye
--date(dateTime):8 btype
--small date:4 byte
--bit:1,0(true,false) ~~boolean
--char(maxSize):string co do dai co dinh maxSize
--varchar(maxSize):String co do dai toi da la maxSize
--nvarChar(maxSize):String co unicode do dai toi da la maxSize

create table Products(pid int, pname nvarchar(100), quantity int, price money,dateCreate datetime,description nvarchar(max), image varchar(100),status bit)

--remove table: drop table table name
drop table Products
--constraint
--primary key
--not null:input required
--check(condition):input by condition
--getDate():current date
--max: maxlength of text
--default:if not input use default
 create table Products(pid int primary key, pname nvarchar(100) not null, quantity int check(quantity>=0), price money,dateCreate datetime check(dateCreate>=getDate()),description nvarchar(max), image varchar(100),status bit not null default 1)