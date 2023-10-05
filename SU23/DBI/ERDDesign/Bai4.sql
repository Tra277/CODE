create database Bai4;
use Bai4;

create table NhomMonHocMo(
	NhomTo nvarchar(255),
	MaMonHoc varchar(255) foreign key references MonHoc(MaMonHoc),
	CONSTRAINT PK_NhomTo PRIMARY KEY (NhomTo,MaMonHoc)
);
create table MonHoc(
	MaMonHoc varchar(255) primary key,
	TenMonHoc nvarchar(255) unique,
	HeSoDKT float not null,
	HeSoDT float not null,
	SoTinChi int
	);
create table Khoa(
	MaKhoa varchar(255) primary key,
	TenKhoa nvarchar(255) unique
	);
create table SinhVien(
	MaKhoa varchar(255) foreign key references Khoa(MaKhoa),
	MaSV varchar(50) primary key,
	TenSinhVien nvarchar(50),
	DiaChi nvarchar(255) 
	);
create table HocKy(
	MaHK varchar(50) primary key,
	Nam varchar(10),
	Dot nvarchar(50),
	MaMonHoc varchar(255) foreign key references MonHoc(MaMonHoc)
	);
create table CoDiem(
	MaSV varchar(50) foreign key references SinhVien(MaSV),
	
	DiemTK float check(DiemTK>=0),
	DiemKT float check(DiemKT>=0),
	DiemThi float check(DiemThi>=0)
	);

