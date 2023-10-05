create database Ws1QuanLyDiem
use Ws1QuanLyDiem

create table Class(
ClassCode varchar(10) primary key,
HeadTeacher varchar(30),
Room varchar(30),
TimeSlot varchar(30),
CloseDate datetime
)
 
create table Student(
RollNo varchar(10) primary key,
ClassCode varchar(10)  foreign key references Class(ClassCode) --1,
FullName varchar(30),
Male bit default 1,
BirthDate datetime,
Address varchar(30),
Province char(2),
Email varchar(30)
)
create table Subject(
SubjectCode varchar(10) primary key,
SubjectName varchar(40),
WTest bit default 1,
PTest bit default 1,
WTest_per smallint,
PTest_per int
)

create table Mark(
RollNo varchar(10) foreign key references Student(RollNo),
SubjectCode varchar(10) foreign key references Subject(SubjectCode),
primary key (RollNo, SubjectCode),
WMark float,
PMark float,
Mark float
)

insert into Class values('C0609M', 'Nguyen Trung', 'Class 2, Lab 2', '19:30 - 21:30','9/25/2008')
insert into Class values('C0611L', 'Phan Dang', 'Class 1, Lab 1', '17:30 - 19:30','10/21/2008')
insert into Class values('T0611H', 'Vu Tran', 'Class 2, Lab 2', '9:30 - 11:30','8/15/2007')

insert into Subject values('C', 'Elementary Programming with C', 1, 1, 40, 60)
insert into Subject values('CF', 'Computer Fundamenttals', 1, 0, 100, 0)
insert into Subject values('DWMX', 'Web Page Designing with Dreamweaver MX', 1, 1, 40, 60)
insert into Subject values('HDJ', 'HTML,DHTML & JavaScript', 1, 1, 40, 60)
insert into Subject values('SQL1', 'SQL1', 1, 0, 100, 0)
insert into Subject values('SQL2', 'SQL2', 1, 1, 40, 60)

insert into Student values('A01', 'C0611L', 'Nguyen Trung', 1, '11/23/1982', '65 Hoang Hoa Tham', 'HN', null)
insert into Student(RollNo, ClassCode, FullName, Male, BirthDate, Province, Email)
values('A02', 'C0611L', 'Thanh Long', 1, '10/21/1983', 'HT', 'trong@fpt.com.vn')
insert into Student values('A03', 'C0611L', 'Dinh Dung', 1, '10/19/1986', '6 Tran Phu', 'HN', 'dung@fpt.vn')
insert into Student values('A04', 'C0611L', 'Xuan Nam', 1, '1/20/1985', '3 Kim Ma', 'HN', null)
insert into Student(RollNo, ClassCode, FullName, Male, BirthDate, Province, Email)
values('A05', 'C0611L', 'Dinh Hieu', 1, '10/10/1984', 'HP', null)
insert into Student(RollNo, ClassCode, FullName, Male, BirthDate, Province, Email)
values('A06', 'C0611L', 'Huong Thao', 0, '9/11/1986', 'ND', 'thao@yahoo.com')
insert into Student(RollNo, ClassCode, FullName, Male, BirthDate, Province, Email)
values('A07', 'C0609M', 'Thu Huong', 0, '10/22/1986', 'ND', null)
insert into Student values('B01', 'C0609M', 'Nguyen Trung', 1, '11/23/1982', '65 Hoang Hoa Tham', 'HN', null)
insert into Student(RollNo, ClassCode, FullName, Male, BirthDate, Province, Email)
values('B02', 'C0609M', 'Thanh Binh', 1, '10/21/1983', 'HT', null)

insert into Mark values('A01', 'C', 20, 10, 14)
insert into Mark values('A01', 'CF', 20, 0, 8)
insert into Mark values('A01', 'HDJ', 18, 12, 14.4)
insert into Mark values('A02', 'C', 23, 15, 18.2)
insert into Mark values('A02', 'CF', 23, 0, 9.2)

--select RollNo, ClassCode, FullName, Male, BirthDate, year(getdate()) - year(BirthDate) as Age, Address, Province, Email from Student

--Bài 1 câu 2
select FullName from Student
--2
where Email like '%fpt.vn' or Email like '%fpt.com.vn'
--3
select * from Class
where Class.ClassCode not in (select ClassCode from Student)
and CloseDate = '2006-07-23'
--4
delete from Mark 
  where RollNo in (select RollNo from Student 
  where ClassCode in (select ClassCode from Class
  where CloseDate < '2015-1-1'))
delete from Student 
  where ClassCode in (select ClassCode from Class 
  where CloseDate < '2015-1-1')
delete from Class where CloseDate < '2015-1-1'
--5
select c.ClassCode, s.RollNo, s.FullName ,count(*) as NumberOfStudent
from Student s join Class c on c.ClassCode=s.ClassCode
group by c.ClassCode, RollNo, FullName	
--6
CREATE VIEW viewClass1 AS 
SELECT * FROM Class 
WHERE (SELECT COUNT(*) FROM Student 
WHERE Student.ClassCode = Class.ClassCode) > 17;
--7
SELECT TOP 1 Subject.SubjectCode, Subject.SubjectName, COUNT(*) AS TotalStudents 
FROM Mark JOIN Subject ON Mark.SubjectCode = Subject.SubjectCode 
GROUP BY Subject.SubjectName, Subject.SubjectCode 
ORDER BY TotalStudents DESC;

-- Bài 2 câu 2
--1
select SubjectCode, count(RollNo) as NumberOfStudent from Mark
where SubjectCode = 'cf'
group by SubjectCode
--2
select SubjectCode, count(RollNo) as NumberOfStudent from Mark
group by SubjectCode 
--3
SELECT Student.FullName, MARK.SubjectCode FROM MARK 
JOIN Student ON MARK.RollNo = Student.RollNo 
WHERE Student.Province LIKE '%HT%' AND MARK.Mark < 10
--4
SELECT Class.ClassCode, COUNT(*) AS NumberOfStudent FROM Class 
JOIN Student ON Class.ClassCode = Student.ClassCode 
GROUP BY Class.ClassCode
--5
SELECT Student.FullName, MARK.SubjectCode FROM MARK 
JOIN Student ON MARK.RollNo = Student.RollNo
--6
SELECT Student.FullName, 
COUNT(MARK.Mark) AS 'Số lần đã tham gia thi' FROM MARK 
JOIN Student ON MARK.RollNo = Student.RollNo 
GROUP BY Student.FullName
--7
SELECT Student.Address, 
AVG(MARK.WMark) AS 'Điểm trung bình' FROM MARK 
JOIN Student ON MARK.RollNo = Student.RollNo 
GROUP BY Student.Address 
ORDER BY AVG(MARK.WMark) DESC
--8
SELECT Student.FullName FROM MARK 
JOIN Student ON MARK.RollNo = Student.RollNo 
GROUP BY Student.FullName 
HAVING AVG(MARK.WMark) > 15




select * from Class
select * from Student
select * from Mark

