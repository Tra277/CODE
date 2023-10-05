CREATE PROCEDURE UpdateCustomerAddress
    @CustomerID nchar(5),
    @Address nvarchar(60)
AS
BEGIN
    UPDATE Customers
    SET Address = @Address
    WHERE CustomerID = @CustomerID;
END;
CREATE TRIGGER trgAfterInsertOrderDetails
ON [Order Details]
AFTER INSERT
AS
BEGIN
    DECLARE @ProductID int;
    DECLARE @Quantity int;
    SELECT @ProductID = i.ProductID, @Quantity = i.Quantity FROM inserted i;
    UPDATE Products
    SET UnitsInStock = UnitsInStock - @Quantity
    WHERE ProductID = @ProductID;
END;
DELETE FROM Customers
WHERE CustomerID = 'ALFKI';
--7
with r as(select top 5 p.* from Product p order by UnitPrice desc
union
select top 5 q.* from Product q order by UnitPrice asc)
select * from r;
WITH Ranges AS (
    SELECT od.CustomerID, c.CustomerName, COUNT(od.ID) as [NumberOfProducts]
    FROM Customer c
    JOIN Orders od
    ON c.ID = od.CustomerID
    GROUP BY od.CustomerID, c.CustomerName
)
SELECT * FROM Ranges
where Ranges.NumberOfProducts = (
	select max(Ranges.NumberOfProducts) from Ranges
)
Câu lệnh case when
SELECT Freight, 
CASE 
    WHEN Freight >= 100 THEN Freight * 1.1 
    ELSE Freight * 1.05 
END AS FreightWithTaxes 
FROM Orders 
WHERE OrderDate BETWEEN '1996-01-08' AND '1996-05-08';
SELECT o.OrderID,day(o.OrderDate) as [OrderDay],month(o.OrderDate) as [OrderMonth],year(o.OrderDate) as[OrderYear],o.Freight, 
CASE 
    WHEN Freight >= 100 THEN '10%' 
    ELSE '5%' 
END AS Tax,
TRIM(Trailing '0' from FORMAT(CASE 
    WHEN Freight >= 100 THEN Freight * 1.1 
    ELSE Freight * 1.05 
END, 'N4')) AS FreightWithTaxes
FROM Orders o
WHERE o.OrderDate BETWEEN '1996/8/1' AND '1996/8/5';