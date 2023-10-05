use QuanLy_WS;
--PART I
--1
create proc SP_1 
@input int
as select * from NHANVIEN
where LUONG > @input

exec SP_1 5000000

--2
create proc SP_2
@s date, @f date
as select * from NHANVIEN
where NGSINH >= @s and NGSINH <=@f

--3
CREATE PROCEDURE SP_3 
@dept_code tinyint
AS
SELECT *
FROM NHANVIEN
WHERE PHG = @dept_code

--4
CREATE PROCEDURE SP_4
AS
SELECT *
FROM NHANVIEN
WHERE MA_NQL IS NULL;

--5
CREATE PROCEDURE SP_5
AS
SELECT *, 
DATEDIFF(MONTH, NGSINH, GETDATE()) AS 'Working time in months'
FROM NHANVIEN ;

--6
CREATE PROCEDURE SP_6
AS
SELECT M.MAPHG, M.TENPHG, COUNT(*) AS 'Number of employees'
FROM NHANVIEN N
INNER JOIN PHONGBAN M ON N.PHG = M.MAPHG
GROUP BY M.MAPHG, M.TENPHG;
--7
CREATE PROCEDURE SP_7
AS
BEGIN
    SELECT MANV, CONCAT(HONV, ' ', TENLOT, ' ', TEN) AS Name, LUONG
    FROM NHANVIEN
    WHERE LUONG > (SELECT AVG(LUONG) FROM NHANVIEN WHERE PHG = NHANVIEN.PHG)
END
exec SP_7
--8
CREATE PROCEDURE SP_8 @N int
AS
BEGIN
    SELECT TOP (@N) MANV, CONCAT(HONV, ' ', TENLOT, ' ', TEN) AS Name, LUONG
    FROM NHANVIEN
    ORDER BY LUONG DESC
END
exec SP_8 1
--9
CREATE PROCEDURE SP_9 @City varchar(30)
AS
BEGIN
    UPDATE NHANVIEN
    SET LUONG = LUONG * 1.1
    FROM NHANVIEN
    INNER JOIN DIADIEM_PHG ON NHANVIEN.PHG = DIADIEM_PHG.MAPHG
    WHERE DIADIEM_PHG.DIADIEM = @City
END
exec SP_9 'Ha Noi'
--10
CREATE PROCEDURE SP_10
AS
BEGIN
    DELETE FROM PHONGBAN
    WHERE MAPHG NOT IN (SELECT PHG FROM NHANVIEN)
END
--PART II
--1
CREATE TRIGGER salary_check
ON NHANVIEN
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (SELECT 1
               FROM NHANVIEN N
               JOIN PHONGBAN P ON N.PHG = P.MAPHG
               GROUP BY P.MAPHG
               HAVING AVG(N.LUONG) >= 50000)
    BEGIN
        ROLLBACK TRANSACTION;
        RAISERROR('The average salary of each department must be fewer than 50000', 16, 1);
    END
END;
--2
CREATE TRIGGER salary_check2
ON NHANVIEN
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (SELECT 1
               FROM NHANVIEN N
               JOIN PHONGBAN P ON N.PHG = P.MAPHG
               WHERE N.LUONG > (SELECT LUONG FROM NHANVIEN WHERE MANV = P.TRPHG))
    BEGIN
        ROLLBACK TRANSACTION;
        RAISERROR('The salary of the head of each department must be greater than or equal to salary of all employees in this department', 16, 1);
    END
END;
--3
CREATE TRIGGER salary_check3
ON NHANVIEN
AFTER INSERT, UPDATE
AS
BEGIN
    DECLARE @avg_salary_HCM FLOAT;
    DECLARE @avg_salary_HN FLOAT;
    SELECT @avg_salary_HCM = AVG(N.LUONG)
    FROM NHANVIEN N
    JOIN DIADIEM_PHG D ON N.PHG = D.MAPHG
    WHERE D.DIADIEM = 'TP HCM';
    SELECT @avg_salary_HN = AVG(N.LUONG)
    FROM NHANVIEN N
    JOIN DIADIEM_PHG D ON N.PHG = D.MAPHG
    WHERE D.DIADIEM = 'HA NOI';
    IF ABS(@avg_salary_HCM - @avg_salary_HN) >= 10000
    BEGIN
        ROLLBACK TRANSACTION;
        RAISERROR('The difference between average salary of employees in HCM and HN must be fewer than 10000', 16, 1);
    END
END;
--4
CREATE TRIGGER family_check
ON NHANVIEN
AFTER INSERT, UPDATE
AS
BEGIN
    IF EXISTS (SELECT 1
               FROM NHANVIEN N1
               JOIN NHANVIEN N2 ON N1.HONV = N2.HONV AND N1.TEN = N2.TEN AND N1.MANV <> N2.MANV
               GROUP BY N1.HONV, N1.TEN
               HAVING COUNT(*) > 5)
    BEGIN
        ROLLBACK TRANSACTION;
        RAISERROR('There is not a group that has more than five employees that are in the same family', 16, 1);
    END
END;
--5
CREATE TRIGGER gender_check
ON NHANVIEN
AFTER INSERT, UPDATE
AS
BEGIN
    DECLARE @male_count FLOAT;
    DECLARE @female_count FLOAT;
    SELECT @male_count = COUNT(*) FROM NHANVIEN WHERE PHAI = 'Nam';
    SELECT @female_count = COUNT(*) FROM NHANVIEN WHERE PHAI = 'Nu';
    IF ABS(@male_count - @female_count) / (@male_count + @female_count) >= 0.1
    BEGIN
        ROLLBACK TRANSACTION;
        RAISERROR('The difference between the number of male and female employees must be fewer than 10%', 16, 1);
    END
END;