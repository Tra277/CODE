use QLDiemWS5;
--1
select * from Lop

--2
select MaSV, HoTen, HocBong from SinhVien

--3
select MaSV, Nu, HocBong from SinhVien where HocBong > 0;

--4
select * from SinhVien where Nu = 1

--5
select * from SinhVien where HoTen like N'Trần%';

--6
select * from SinhVien where Nu = 1 and HocBong > 0
--7
SELECT HoTen, Nu, HocBong
FROM SinhVien
WHERE Nu = 1 OR HocBong > 0;
--8
SELECT *
FROM SinhVien
WHERE NgaySinh BETWEEN '1978-01-01' AND '1985-12-31';
--9
SELECT *
FROM SinhVien
ORDER BY MaSV ASC;
--10
SELECT *
FROM SinhVien
ORDER BY HocBong DESC;
--11
SELECT SinhVien.MaSV, SinhVien.HoTen, KetQua.DiemThi
FROM SinhVien
JOIN KetQua ON SinhVien.MaSV = KetQua.MaSV
JOIN MonHoc ON KetQua.MaMH = MonHoc.MaMH
WHERE MonHoc.TenMH = N'CSDL' AND KetQua.DiemThi >= 8;
--12
SELECT SinhVien.MaSV, SinhVien.HoTen, SinhVien.HocBong, Lop.TenLop
FROM SinhVien
JOIN Lop ON SinhVien.MaLop = Lop.MaLop
JOIN Khoa ON Lop.MaKhoa = Khoa.MaKhoa
WHERE Khoa.MaKhoa = 'CNTT' AND SinhVien.HocBong > 0;
--13
SELECT SinhVien.MaSV, SinhVien.HoTen, SinhVien.HocBong, Lop.TenLop, Khoa.TenKhoa
FROM SinhVien
JOIN Lop ON SinhVien.MaLop = Lop.MaLop
JOIN Khoa ON Lop.MaKhoa = Khoa.MaKhoa
WHERE Khoa.MaKhoa = 'CNTT' AND SinhVien.HocBong > 0;
--14
SELECT Lop.TenLop, COUNT(SinhVien.MaSV) AS SoSinhVien
FROM Lop
LEFT JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Lop.TenLop;
--15
SELECT Khoa.TenKhoa, COUNT(SinhVien.MaSV) AS SoSinhVien
FROM Khoa
LEFT JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
LEFT JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.TenKhoa;
--16
SELECT Khoa.TenKhoa, COUNT(SinhVien.MaSV) AS SoSinhVienNu
FROM Khoa
LEFT JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
LEFT JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
WHERE SinhVien.Nu = 1
GROUP BY Khoa.TenKhoa;
--17
SELECT Lop.TenLop, SUM(SinhVien.HocBong) AS TongHocBong
FROM Lop
LEFT JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Lop.TenLop;
--18
SELECT Khoa.TenKhoa, SUM(SinhVien.HocBong) AS TongHocBong
FROM Khoa
LEFT JOIN Lop ON Khoa.MaKhoa = Lop.MaKhoa
LEFT JOIN SinhVien ON Lop.MaLop = SinhVien.MaLop
GROUP BY Khoa.TenKhoa;