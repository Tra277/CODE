--create database ABC;
use ABC;

create table KHACHHANG(
	MAKH NVARCHAR(5) PRIMARY KEY,
	TENKH NVARCHAR(30) NOT NULL,
	DIACHI NVARCHAR(50),
	DT NVARCHAR(10) CHECK(LEN(DT)>=7 AND LEN(DT)<=10),
	EMAIL NVARCHAR(30)
); 
SELECT * FROM KHACHHANG;

CREATE TABLE SANPHAM (
    MAVT NVARCHAR(5) PRIMARY KEY,
    TENVT NVARCHAR(30) NOT NULL,
    DVT NVARCHAR(20),
    GIAMUA INT CHECK (GIAMUA > 0),
    SLTON INT CHECK (SLTON >= 0)
);
SELECT * FROM SANPHAM;

CREATE TABLE HOADON (
    MAHD NVARCHAR(10) PRIMARY KEY,
    NGAY DATETIME CHECK (NGAY < GETDATE()),
    MAKH NVARCHAR(5),
    TONGTG INT
);
SELECT * FROM HOADON;

CREATE TABLE CHITIETHOADON (
    MAHD NVARCHAR(10) FOREIGN KEY REFERENCES HOADON(MAHD),
    MAVT NVARCHAR(5) FOREIGN KEY REFERENCES SANPHAM(MAVT),
    SL INT CHECK (SL > 0),
    KHUYENMAI INT,
    GIABAN INT
);
SELECT * FROM CHITIETHOADON;

INSERT INTO SANPHAM (MaVT, TenVT, DVT, GIAMUA, SLTON)
VALUES
('VT01', 'XI MANG', 'BAO', 50000, 5000),
('VT02', 'CAT', 'KHOI', 45000, 50000),
('VT03', 'GACH ONG', 'VIEN', 120, 800000),
('VT04', 'GACH THE', 'VIEN', 110, 800000),
('VT05', 'DA LON', 'KHOI', 25000, 100000),
('VT06', 'DA NHO', 'KHOI', 33000, 100000);

INSERT INTO KHACHHANG
VALUES
('KH01', 'NGUYEN THI BE', 'TAN BINH', '8457895', 'bnt@yahoo.com'),
('KH02', 'LE HOANG NAM', 'BINH CHANH', '9878987', 'namlehoang@abc.com.vn'),
('KH03', 'TRAN THI CHIEU', 'TAN BINH', '8457895', NULL),
('KH04', 'MAI THI QUE ANH', 'BINH CHANH', NULL, NULL),
('KH05', 'LE VAN SANG', 'QUAN 10', NULL, 'sanglv@hcm.vnn.vn'),
('KH06', 'TRAN HOANG KHAI', 'TAN BINH', '8457897' ,NULL);
SELECT * FROM KHACHHANG;

INSERT INTO HOADON (MAHD, NGAY, MAKH)
VALUES
('HD001','2000-05-12','KH01'),
('HD002','2000-05-25','KH02'),
('HD003','2000-05-25','KH01'),
('HD004','2000-05-25','KH04'),
('HD005','2000-05-26','KH04'),
('HD006','2000-06-02','KH03'),
('HD007','2000-06-22','KH04'),
('HD008','2000-06-25','KH03'),
('HD009','2000-08-15','KH04'),
('HD010','2000-09-30','KH01');

INSERT INTO CHITIETHOADON (MAHD, MAVT, SL, GIABAN)
VALUES
('HD001','VT01' ,5 ,52000),
('HD001','VT05' ,10 ,30000),
('HD002','VT03' ,10000 ,150),
('HD003','VT02' ,20 ,55000),
('HD004','VT03' ,50000 ,150),
('HD004','VT04' ,20000 ,120),
('HD005','VT05' ,10 ,30000),
('HD006','VT04' ,10000 ,120),
('HD007','VT04' ,20000 ,125),
('HD008','VT01' ,100 ,55000),
('HD009','VT02' ,25 ,48000),
('HD010','VT01' ,25 ,57000);