/*
This query text was retrieved from showplan XML, and may be truncated.
*/

/*
Convert ERD --> database
1 entity --> table (key,attributes(entity) --> table)
Relationship
1-1: Khóa chính - khóa chính: Không làm gì (thuộc tính khóa bên này làm khóa ngoại bên kia hoặc ngược lại )
1-n : chuyển khóa chính bên 1 sang làm khóa ngoại bên nhiều (thường là viết bên nhiều )
n-n: Quan hệ --> table; (hiểu nôm na là viết ra một bảng mới cói hai khóa ngoại của hai bảng cũ)
	key newtable = key quan hệ (nếu có) + key table n + key table m 
	attribute quan hệ --> fields of newtable
	note: key table n is FK; key table m is FK 
multivalue attribute --> newtable 
sub entity --> new table with  key of main entity

*/
--note:PK có trước rồi mới có FK --> tạo bảng bên 1 trước , bên n sau
--drop database task4
create database task4
use task4

create table MonHoc(maMon varchar(30) primary key, tenMon nvarchar(100) not null)
--identity(start,step);puto number have start with step
create table hocky(maHK int primary key identity(1,1), tenHK nvarchar(50) not null)
--
create table Khoa(maKhoa varchar(50) primary key, tenKhoa nvarchar(50))
create table NhomMon(maNhom varchar(30) primary key,maMonHoc varchar(30) foreign key references MonHoc(maMon),mark int foreign key references hocKy(maHK))
create table sinhvien(maSV varchar(30) primary key, tenSV nvarchar(30),
username varchar(50) unique, password varchar(32) check(len(password)>=8),
maKhoa varchar(50) foreign key references Khoa(maKhoa))
create table Diem(Diemthi float,diemKT float,diemTK float check(diemTK>=0 AND diemTK<=10),maSV varchar(30) foreign key references sinhvien(maSV), maNhom varchar(30) foreign key references NhomMon(maNhom),
primary key(maSV,maNhom))

--date: ngày tháng
--datetime: ngày tháng và thời gian
--money: kiểu tiền tệ
--số nguyên: int, big int
--float,decimal : kiểu số thực 
