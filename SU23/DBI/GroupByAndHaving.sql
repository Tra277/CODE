use Northwind
/*select...
from...
where..
group by...
having...
order by...
select ... where ...group ... having
*/
select * from Products
--count : number of records.
select count(*) as Concu from Products
select count(ProductID) as Concu from Products;
select count(ProductName) as Concu from Products;
select count(*) from Products
where UnitsInStock=0;

select sum(UnitsInStock) from Products

select count(*) as SoLuong, sum(UnitsInStock) as Tien from Products

select min(UnitsInStock) as GTNN, max(UnitsInStock) as GTLN,AVG(UnitsInStock) as [Trung binh] from Products;

--Tuy nhien ham nay lai khong the dung cung voi cac ham khac duoc (Vi ham sum,min,max...) la duoc tinh tren tat ca cac ban ghi, thường thì các hàm này được sử dụng trong where
select b.CategoryID,b.CategoryID,a.ProductID,a.ProductName,a.UnitPrice,a.UnitsInStock,a.UnitsOnOrder,c.SupplierID,c.CompanyName
from Products as a join Categories as b on a.CategoryID = b.CategoryID
		join Suppliers as c on a.SupplierID=c.SupplierID
		order by b.CategoryID;

select b.CategoryID,b.CategoryName,c.SupplierID,c.CompanyName,count(b.CategoryID) as NumberOfProducts
from Products as a join Categories as b on a.CategoryID = b.CategoryID
		join Suppliers as c on a.SupplierID=c.SupplierID
		group by c.SupplierID,c.CompanyName,b.CategoryID,b.CategoryName
		order by c.SupplierID;

select TitleOfCourtesy,count(*) from Employees
group by TitleOfCourtesy
