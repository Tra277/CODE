use QuanLyDiemSV;

--32
select count(MaSV) as TongSoSV from DMSV
--33
select 'Tổng sinh viên' = count(MaSV), 'Tổng sinh viên nữ' = sum(case phai when N'nữ' then 1 else 0 end) from DMSV
--34
select makhoa, count(MaSV) as 'Tổng sinh viên' from DMSV group by MaKhoa
--35
select MaMH, count(MaSV) as 'Số lượng sinh viên' from KetQua group by MaMH
select * from KetQua
--36
select count(distinct MaMH) as 'Tổng số môn học' from KetQua
--37
select MaKhoa as 'Mã khoa', sum(HocBong) as 'Tổng học bổng' from DMSV group by MaKhoa
--38
select MaKhoa as 'Mã khoa', max(HocBong) as 'Học bổng cao nhất' from DMSV group by MaKhoa
--39
select MaKhoa as 'Mã khoa', sum(case when Phai = N'Nam' then 1 else 0 end) as 'Tổng số sinh viên nam', 
sum(case when Phai = N'Nữ' then 1 else 0 end) as 'Tổng số sinh viên nữ' from DMSV group by MaKhoa
--40
SELECT DATEDIFF(year, NgaySinh, CURRENT_TIMESTAMP) AS Age, COUNT(*) AS TotalStudents
FROM DMSV
GROUP BY DATEDIFF(year, NgaySinh, CURRENT_TIMESTAMP);
--41
SELECT YEAR(NgaySinh) AS YearOfBirth, COUNT(*) AS TotalStudents
FROM DMSV
GROUP BY YEAR(NgaySinh)
HAVING COUNT(*) = 2;
--42
SELECT NoiSinh, COUNT(*) AS TotalStudents
FROM DMSV
GROUP BY NoiSinh
HAVING COUNT(*) > 2;
--43
SELECT MaMH, COUNT(DISTINCT MaSV) AS TotalStudents
FROM KetQua
GROUP BY MaMH
HAVING COUNT(DISTINCT MaSV) > 3;
--44
SELECT MaSV, COUNT(*) AS TotalExams
FROM KetQua
GROUP BY MaSV
HAVING COUNT(*) > 2;
--45
SELECT DMSV.MaSV, AVG(KetQua.Diem) AS AverageGrade
FROM DMSV
JOIN KetQua
ON DMSV.MaSV = KetQua.MaSV
WHERE KetQua.LanThi = 1 AND DMSV.Phai = N'Nam'
GROUP BY DMSV.MaSV
HAVING AVG(KetQua.Diem) > 7.0;
--46
SELECT MaSV, COUNT(*) AS TotalFailedSubjects
FROM KetQua
WHERE LanThi = 1 AND Diem < 5
GROUP BY MaSV
HAVING COUNT(*) > 2;
--47
SELECT MaKhoa, COUNT(*) AS TotalMaleStudents
FROM DMSV
WHERE Phai = N'Nam'
GROUP BY MaKhoa
HAVING COUNT(*) > 2;
--48
SELECT MaKhoa, COUNT(*) AS TotalStudents
FROM DMSV
WHERE HocBong BETWEEN 200000 AND 300000
GROUP BY MaKhoa
HAVING COUNT(*) = 2;
--49
SELECT MaMH, 
SUM(CASE WHEN Diem >= 5 THEN 1 ELSE 0 END) AS TotalPassed, 
SUM(CASE WHEN Diem < 5 THEN 1 ELSE 0 END) AS TotalFailed
FROM KetQua
WHERE LanThi = 1
GROUP BY MaMH;
--50
SELECT MaKhoa, 
SUM(CASE WHEN Phai = N'Nam' THEN 1 ELSE 0 END) AS TotalMaleStudents, 
SUM(CASE WHEN Phai = N'Nữ' THEN 1 ELSE 0 END) AS TotalFemaleStudents
FROM DMSV
GROUP BY MaKhoa;
