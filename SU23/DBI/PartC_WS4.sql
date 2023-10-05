use QuanLyDiemSV;
--26
SELECT HoSV, TenSV, NoiSinh, NgaySinh
FROM DMSV
WHERE NoiSinh = N'Hà Nội' AND MONTH(NgaySinh) = 2;
--27
SELECT CONCAT(HoSV, ' ', TenSV) AS HoTenSV, DATEDIFF(year, NgaySinh, GETDATE()) AS Tuoi, HocBong
FROM DMSV
WHERE DATEDIFF(year, NgaySinh, GETDATE()) > 20;
--28
SELECT CONCAT(DMSV.HoSV, ' ', DMSV.TenSV) AS HoTenSV, DATEDIFF(year, DMSV.NgaySinh, GETDATE()) AS Tuoi, DMKhoa.TenKhoa
FROM DMSV
JOIN DMKhoa ON DMSV.MaKhoa = DMKhoa.MaKhoa
WHERE DATEDIFF(year, DMSV.NgaySinh, GETDATE()) BETWEEN 20 AND 25;
--29
SELECT CONCAT(HoSV, ' ', TenSV) AS HoTenSV, Phai, NgaySinh
FROM DMSV
WHERE MONTH(NgaySinh) BETWEEN 1 AND 3 AND YEAR(NgaySinh) = 1990;
--30
SELECT MaSV, Phai, MaKhoa,
    CASE
        WHEN HocBong > 500000 THEN N'Học bổng cao'
        ELSE N'Mức trung bình'
    END AS N'Mức học bổng'
FROM DMSV;