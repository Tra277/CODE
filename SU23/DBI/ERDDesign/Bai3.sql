create database Bai3
use Bai3

create table MonHoc(
	maMonHoc varchar(50) primary key,
	tenMonHoc nvarchar(255) unique,
	soTinChi int 
);


CREATE TABLE KhoaHoc
(
	maMonHoc varchar(50) foreign key references MonHoc(maMonHoc),
    maKhoaHoc int IDENTITY(1,1),
    namHoc int not null,
	hocKy int not null,
    SoHK AS (namHoc + hocKy),
	primary key (maMonHoc,maKhoaHoc)
);

create table TienQuyet(
	maMonHoc varchar(50) foreign key references MonHoc(maMonHoc)
	);