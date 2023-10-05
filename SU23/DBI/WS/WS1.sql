create database QLDIEM;
use QLDIEM;

drop table Class

create table Class(
    ClassCode varchar(10)  primary key,
	HeadTeacher varchar(30),
	Room varchar(30),
	TimeSlot varchar(30),
	CloseDate dateTime
)

create table Student(
    RollNo varchar(10)  primary key,
	ClassCode varchar(10) foreign key references Class(ClassCode),
	FullName varchar(30),
	Male bit,
	BirthDate datetime,
	Address varchar(30),
	Province char(2),
	Email varchar(30)
)

create table Mark(
	RollNo varchar(10) foreign key references Student(RollNo),
    SubjectCode varchar(10) foreign key references Subject(SubjectCode),
	constraint PK_Mark primary key (RollNo,SubjectCode),
	WMark float,
	PMark float,
	Mark float,
)

create table Subject(
    SubjectCode varchar(10) primary key,
	SubjectName varchar(40),
	WTest bit,
	PTest bit,
	WTest_per smallint,
	PTest_per int
)

insert into Class
values ('C0609M','Nguyen Trung','Class 2,lab 2','19:30 - 21:30','9/25/2008');
insert into Class
values ('C0611L','Phan Dang','Class 1,Lab 1','17:30 - 19:30','10/21/2008');
insert into Class
values ('T0611H','Vu Tran','Class 2,lab 2','9:30 - 11:30','8/15/2007');

insert into Subject
values ('C','Elementary Programing with C',1,1,40,60);
insert into Subject
values ('CF','Computer Fundamentals',1,0,100,0);
insert into Subject
values ('DWMX','Web Page Designing with Dreamweaver MX',1,1,40,60);
insert into Subject
values ('HDJ','HTML,DHTML & JavaScript',1,1,40,60);
insert into Subject
values ('SQL1','SQL1',1,0,100,0);
insert into Subject
values ('SQL2','SQL2',1,1,40,60);

insert into Student
values ('A01','C0611L','Nguyen Hung',1,'11/23/1982','65 Hoang Hoa Tham','HN', null);
insert into Student
values ('A02','C0611L','Thanh Trong',1,'10/21/1983','','HT', 'trong@fpt.com.vn');
insert into Student
values ('A03','C0611L','Dinh Dung',1,'10/19/1986','6 Tran Phu','HN', 'dung@fpt.vn');
insert into Student
values ('A04','C0611L','Xuan Nam',1,'1/20/1985','3 Kim Ma','HN', null);
insert into Student
values ('A05','C0611L','Dinh Hieu',1,'10/10/1984','','HP', null);
insert into Student
values ('A06','C0611L','Huong Thao',0,'9/11/1986','','ND', 'thao@yahoo.com');
insert into Student
values ('A07','C0611L','Thu Huong',0,'10/22/1986','','ND', null);
insert into Student
values ('B01','C0609M','Nguyen Hung',1,'11/23/1982','65 Hoang Hoa Tham','HN', null);
insert into Student
values ('B02','C0609M','Thanh Binh',1,'10/21/1983','','HT', null);

insert into Mark
values ('A01','C',20,10,14);
insert into Mark
values ('A01','CF',20,0,8);
insert into Mark
values ('A01','HDJ',18,12,14.4);
insert into Mark
values ('A02','C',23,15,18.2);
insert into Mark
values ('A02','CF',23,0,9.2);