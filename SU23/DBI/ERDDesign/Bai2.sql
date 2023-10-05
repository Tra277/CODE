create database Bai2
use Bai2

CREATE TABLE Item (
    ItemNumber int PRIMARY KEY,
    ItemSpecification varchar(255),
    OrderPrice float,
    [Condition] varchar(255)
);

CREATE TABLE Customer(
    CustomerCode int PRIMARY KEY,
    CustomerName varchar(255),
    Address varchar(255),
    TypeID int FOREIGN KEY REFERENCES CustomerType(TypeID)
);

CREATE TABLE Sale (
    SaleID int PRIMARY KEY,
    Commission float,
    SellingPrice float,
    SalesTax float,
    SaleDate date,
    CustomerCode int FOREIGN KEY REFERENCES Customer(CustomerCode),
    ItemNumber int FOREIGN KEY REFERENCES Item(ItemNumber)
);

CREATE TABLE Purchase (
    PurchaseID int PRIMARY KEY,
    PurchasePrice float,
    PurchaseDate date,
    [Condition] varchar(255),
    CustomerCode int FOREIGN KEY REFERENCES Customer(CustomerCode),
    ItemNumber int FOREIGN KEY REFERENCES Item(ItemNumber)
);

CREATE TABLE CustomerType (
    TypeID int PRIMARY KEY,
    TypeName varchar(255)
);
