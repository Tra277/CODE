create database vd1
use vd1
drop table SinhVien
drop table LopSinhVien

create table SinhVien(
	MSSV varchar(255) primary key,
	HOVATEN nvarchar(255),	
	NOISINH nvarchar(max),
	NGAYSINH date not null,
	GIOITINH varchar(5) not null
);

create table LopSinhVien(
	MaSoLop varchar(255) primary key,
	TenLop varchar(255)
);

alter table SinhVien add MaSoLop varchar(255);
alter table SinhVien 
add foreign key (MaSoLop) references LopSinhVien(MaSoLop);