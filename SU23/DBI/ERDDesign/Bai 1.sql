create database Bai1
use Bai1

create table NhanVien(
	MaNV varchar(50) primary key,
	TenNV nvarchar(255),
	DiaChi nvarchar(255),
	NgaySinh date 
);

create table DuAn(
	MaDuAN varchar(255) primary key,
	TenDuAn nvarchar(255),
	NgayBDau date

);

create table ThamGia(
	Luong float,
	MaDuAn varchar(255) foreign key references DuAn(MaDuAn),
	MaNV varchar(50) foreign key references NhanVien(MaNV),
	primary key (MaDuAn,MaNV)
);
