--Cau 9
SELECT MaSV, HoSV, TenSV, HocBong
FROM DMSV
ORDER BY MaSV ASC;
--Cau 10
SELECT MaSV, HoSV, TenSV, Phai, NgaySinh
FROM DMSV
ORDER BY Phai ASC;
--11--
select HoSV,TenSV,NgaySinh,HocBong from DMSV
Order by NgaySinh, HocBong DESC
--12
SELECT MaMH,TenMH,SoTiet
FROM DMMH
where TenMH like 't%'
go
--13--
SELECT HoTenSV =HoSV +' '+ TenSV ,NgaySinh,Phai
FROM DMSV
where TenSV like '%i'
go
--14--
SELECT MaKhoa, TenKhoa
FROM DMKhoa
where TenKhoa like '_n%'
go
--15--
SELECT HoTenSV =HoSV +' '+ TenSV 
FROM DMSV
where HoSV like '%Thu%' 
select * from DMSV
go
--16--
SELECT MaSV, HoTenSV =HoSV +' '+ TenSV, Phai, HocBong 
FROM DMSV
where HoSV like '[a-m]%' 
go 
--17--
select HoTenSV=HoSV+TenSV,NgaySinh,NoiSinh,HocBong from DMSV  where TenSV like '[a-m]%'
order by HoSV,TenSV
--18--
select MaSV, HoTen = HoSV+TenSV,MaKhoa,HocBong from DMSV where HocBong> 100000
order by MaKhoa desc  
--19--
select HoTen= HoSV+TenSV,MaKhoa,NoiSinh,HocBong from DMSV where HocBong >150000 and NoiSinh like '%i'
--20--
SELECT MaSV, MaKhoa, Phai
FROM DMSV
WHERE MaKhoa = 'AV' OR MaKhoa = 'VL';

--21--
SELECT MaSV, NgaySinh, NoiSinh, HocBong
FROM DMSV
WHERE NgaySinh BETWEEN '1991-01-01' AND '1992-06-05';

--22-- 
SELECT MaSV, NgaySinh, Phai, MaKhoa
FROM DMSV
WHERE HocBong BETWEEN 80000 AND 150000;

--23--
SELECT MaMH,TenMH,SoTiet
FROM DMMH
WHERE SoTiet BETWEEN 30 AND 45;

--24--
SELECT MaSV, HoTen= HoSV + TenSV,MaKhoa, Phai
FROM DMSV
WHERE (MaKhoa = 'AV' OR MaKhoa = 'TH') AND Phai = 'Nam';
--25--
SELECT *
FROM DMSV
WHERE Phai like 'Nữ' AND LOWER(TenSV) LIKE N'%n%';