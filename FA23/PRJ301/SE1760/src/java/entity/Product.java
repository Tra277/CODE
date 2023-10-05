/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class Product {
    private int ProductID;
    private String ProductName;
    private int SupplierID,CategoryID;
    private String QuantityPerUnit;
    private double UnitPrice;
    private int UnitInStock,UnitsOnOrder,ReorderLevel,Discontinued;

    public Product( String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitInStock, int UnitsOnOrder, int ReorderLevel, int Discontinued) {
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitInStock = UnitInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
    }

    public Product(int ProductID, String ProductName, int SupplierID, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitInStock, int UnitsOnOrder, int ReorderLevel, int Discontinued) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitInStock = UnitInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
    }
    

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getUnitInStock() {
        return UnitInStock;
    }

    public void setUnitInStock(int UnitInStock) {
        this.UnitInStock = UnitInStock;
    }

    public int getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(int UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }

    public int getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(int ReorderLevel) {
        this.ReorderLevel = ReorderLevel;
    }

    public int getDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(int Discontinued) {
        this.Discontinued = Discontinued;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", SupplierID=" + SupplierID + ", CategoryID=" + CategoryID + ", QuantityPerUnit=" + QuantityPerUnit + ", UnitPrice=" + UnitPrice + ", UnitInStock=" + UnitInStock + ", UnitsOnOrder=" + UnitsOnOrder + ", ReorderLevel=" + ReorderLevel + ", Discontinued=" + Discontinued + '}';
    }
    
}
