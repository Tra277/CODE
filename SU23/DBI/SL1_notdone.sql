create database testDB;
drop database testDB;

create table Persons(PersonID int,LastName varchar(255),FirseName varchar(255),Address varchar(255),City varchar(255));

drop table Persons;

/*The ALTER TABLE statement is used to add, delete, or modify columns in an existing table.

The ALTER TABLE statement is also used to add and drop various constraints on an existing table.*/

--add collumn
alter table Persons
add Email varchar(255);

--drop collumn
alter table Persons
drop column Email

--Constraint: ràng buộc 
/*Constraints can be column level or table level.
Column level constraints apply to a column, and table level constraints apply to the whole table.*/
--VD1
create table Persons(PersonID int not null primary key,LastName varchar(255),FirseName varchar(255),Address varchar(255),City varchar(255));
--or VD2
create table Persons(PersonID int,LastName varchar(255),FirseName varchar(255),Address varchar(255),City varchar(255),CONSTRAINT PK_Person PRIMARY KEY (PersonID,LastName));

--DROP a PRIMARY KEY Constraint
ALTER TABLE Persons
DROP CONSTRAINT PK_Person;

--NOTDONE: Tìm hiểu sâu về từng ràng buộc trên W3School
--SQL NOT NULL on CREATE TABLE
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    Age int
);
--SQL NOT NULL on ALTER TABLE
ALTER TABLE Persons
ALTER COLUMN Age int NOT NULL;

--SQL UNIQUE on CREATE TABLE
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    CONSTRAINT UC_Person UNIQUE (ID,LastName)
);
--SQL UNIQUE Constraint on ALTER TABLE
ALTER TABLE Persons
ADD CONSTRAINT UC_Person UNIQUE (ID,LastName);

--DROP a UNIQUE Constraint
ALTER TABLE Persons
DROP CONSTRAINT UC_Person;

--SQL FOREIGN KEY on CREATE TABLE
CREATE TABLE Orders (
    OrderID int NOT NULL PRIMARY KEY,
    OrderNumber int NOT NULL,
    PersonID int FOREIGN KEY REFERENCES Persons(PersonID)
);

CREATE TABLE Orders (
    OrderID int NOT NULL,
    OrderNumber int NOT NULL,
    PersonID int,
    PRIMARY KEY (OrderID),
    CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID)
    REFERENCES Persons(PersonID)
);