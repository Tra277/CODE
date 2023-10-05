--CREATE DATABASE QLDiemWS5;
USE QLDiemWS5;

CREATE TABLE Khoa (
    MaKhoa VARCHAR(20) PRIMARY KEY,
    TenKhoa NVARCHAR(50),
    SoCBGD INT
);

CREATE TABLE Lop (
    MaLop INT IDENTITY(1,1) PRIMARY KEY,
    TenLop NVARCHAR(50),
    MaKhoa VARCHAR(20) FOREIGN KEY REFERENCES Khoa(MaKhoa)
);

CREATE TABLE SinhVien (
    MaSV INT IDENTITY(1,1) PRIMARY KEY,
    HoTen NVARCHAR(50),
    Nu BIT,
    NgaySinh DATE,
    MaLop INT FOREIGN KEY REFERENCES Lop(MaLop),
    HocBong INT,
    Tinh NVARCHAR(50)
);

CREATE TABLE MonHoc (
    MaMH INT IDENTITY(1,1) PRIMARY KEY,
    TenMH NVARCHAR(50),
    SoTiet INT
);

CREATE TABLE KetQua (
    MaSV INT FOREIGN KEY REFERENCES SinhVien(MaSV),
    MaMH INT FOREIGN KEY REFERENCES MonHoc(MaMH),
    DiemThi FLOAT,
    PRIMARY KEY (MaSV, MaMH)
);

-- Insert 3 records into Khoa table
INSERT INTO Khoa (MaKhoa, TenKhoa, SoCBGD)
VALUES ('CNTT', N'Khoa Công Nghệ Thông Tin', 50),
       ('QTKD', N'Khoa Quản Trị Kinh Doanh', 40),
       ('NN', N'Khoa Ngoại Ngữ', 30);

-- Insert 6 records into Lop table
INSERT INTO Lop (TenLop, MaKhoa)
VALUES (N'Lớp CNTT1', 'CNTT'),
       (N'Lớp CNTT2', 'CNTT'),
       (N'Lớp QTKD1', 'QTKD'),
       (N'Lớp QTKD2', 'QTKD'),
       (N'Lớp NN1', 'NN'),
       (N'Lớp NN2', 'NN');

-- Insert 3 records into MonHoc table
INSERT INTO MonHoc (TenMH, SoTiet)
VALUES (N'Toán cao cấp', 45),
       (N'Tin học cơ sở', 30),
       (N'Anh văn', 60);

-- Insert 6 records into SinhVien table
INSERT INTO SinhVien (HoTen, Nu, NgaySinh, MaLop, HocBong, Tinh)
VALUES (N'Nguyễn Văn A', 0, '2000-01-01', 1, 1000000, N'Hà Nội'),
       (N'Trần Thị B', 1, '2000-02-02', 1, 2000000, N'Hải Phòng'),
       (N'Phạm Văn C', 0, '2000-03-03', 2, 1500000, N'Nam Định'),
       (N'Đỗ Thị D', 1, '2000-04-04', 3, 2500000, N'Thái Bình'),
       (N'Lê Văn E', 0, '2000-05-05', 4, 3000000, N'Quảng Ninh'),
       (N'Hoàng Thị F', 1, '2000-06-06', 5, 3500000, N'Bắc Giang');

-- Insert some records into KetQua table
INSERT INTO KetQua (MaSV, MaMH, DiemThi)
VALUES (1, 1, 8.5),
       (1, 2, 7.5),
       (1, 3, 9.0),
       (2, 1, 8.0),
       (2, 2, 7.0),
       (2, 3, 8.5);