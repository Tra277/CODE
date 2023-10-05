--Create Database QuanLyDiemSV
--use QuanLyDiemSV

CREATE TABLE DMKhoa
(
MaKhoa char(2) PRIMARY KEY,
TenKhoa nvarchar(30) NOT NULL
);

CREATE TABLE DMSV
(
MaSV char(3) NOT NULL PRIMARY KEY,
HoSV nvarchar(15) NOT NULL,
TenSV nvarchar(7) NOT NULL,
Phai nchar(7),
NgaySinh datetime NOT NULL,
NoiSinh nvarchar(20),
MaKhoa char(2),
HocBong float,
);

CREATE TABLE DMMH
(
MaMH char(2) NOT NULL,
TenMH nvarchar(25) NOT NULL,
SoTiet tinyint,
CONSTRAINT DMMH_MaMH_pk PRIMARY KEY(MaMH)
);

CREATE TABLE KetQua
(
MaSV char(3) NOT NULL,
MaMH char(2) NOT NULL,
LanThi tinyint,
Diem decimal(4,2),
CONSTRAINT KetQua_MaSV_MaMH_LanThi_pk PRIMARY KEY(MaSV,MaMH,LanThi)
);

ALTER TABLE dmsv
ADD CONSTRAINT DMKhoa_MaKhoa_fk FOREIGN KEY(MaKhoa)
REFERENCES DMKhoa (MaKhoa);

ALTER TABLE KetQua
ADD CONSTRAINT KetQua_MaSV_fk FOREIGN KEY(MaSV) REFERENCES DMSV (MaSV),
CONSTRAINT DMMH_MaMH_fk FOREIGN KEY(MaMH) REFERENCES DMMH (MaMH);

SET DATEFORMAT DMY;
GO

INSERT INTO DMMH(MaMH,TenMH,SoTiet)
VALUES('01',N'Cơ Sở Dữ Liệu',45);
INSERT INTO DMMH(MaMH,TenMH,SoTiet)
VALUES('02',N'Trí Tuệ Nhân Tạo',45);
INSERT INTO DMMH(MaMH,TenMH,SoTiet)
VALUES('03',N'Truyền Tin',45);
INSERT INTO DMMH(MaMH,TenMH,SoTiet)
VALUES('04',N'Đồ Họa',60);
INSERT INTO DMMH(MaMH,TenMH,SoTiet)
VALUES('05',N'Văn Phạm',60);

INSERT INTO DMKhoa(MaKhoa,TenKhoa)
VALUES('AV',N'Anh Văn');
INSERT INTO DMKhoa(MaKhoa,TenKhoa)
VALUES('TH',N'Tin Học');
INSERT INTO DMKhoa(MaKhoa,TenKhoa)
VALUES('TR',N'Triết');
INSERT INTO DMKhoa(MaKhoa,TenKhoa)
VALUES('VL',N'Vật Lý');

INSERT INTO DMSV
VALUES('A01',N'Nguyễn Thị',N'Hải',N'Nữ','23/02/1990',N'Hà Nội','TH',130000);
INSERT INTO DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
VALUES('A02',N'Trần Văn',N'Chính',N'Nam','24/12/1992',N'Bình Định','VL',150000);
INSERT INTO DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
VALUES('A03',N'Lê Thu Bạch',N'Yến',N'Nữ','21/02/1990',N'TP Hồ Chí Minh','TH',170000);
INSERT INTO DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
VALUES('A04',N'Trần Anh',N'Tuấn',N'Nam','20/12/1990',N'Hà Nội','AV',80000);
INSERT INTO DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
VALUES('B01',N'Trần Thanh',N'Mai',N'Nữ','12/08/1991',N'Hải Phòng','TR',0);
INSERT INTO DMSV(MaSV,HoSV,TenSV,Phai,NgaySinh,NoiSinh,MaKhoa,HocBong)
VALUES('B02',N'Trần Thị Thu',N'Thủy',N'Nữ','02/01/1991',N'TP Hồ Chí Minh','AV',0);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A01','01',1,3);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A01','01',2,6);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A01','02',2,6);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A01','03',1,5);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A02','01',1,4.5);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A02','01',2,7);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A02','03',1,10);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A02','05',1,9);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A03','01',1,2);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A03','01',2,5);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A03','03',1,2.5);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A03','03',2,4);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('A04','05',2,10);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('B01','01',1,7);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('B01','03',1,2.5);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('B01','03',2,5);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('B02','02',1,6);
INSERT INTO KetQua(MaSV,MaMH,LanThi,Diem)
VALUES('B02','04',1,10);