/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexf
 */
public class DAOProduct extends DBConnect {

    public int insertProduct(Product pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([ProductName]\n"
                + "           ,[SupplierID]\n"
                + "           ,[CategoryID]\n"
                + "           ,[QuantityPerUnit]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitsInStock]\n"
                + "           ,[UnitsOnOrder]\n"
                + "           ,[ReorderLevel]\n"
                + "           ,[Discontinued])\n"
                + "     VALUES\n"
                + "           ('" + pro.getProductName() + "'," + pro.getSupplierID() + "," + pro.getCategoryID()
                + ",'" + pro.getQuantityPerUnit() + "'," + pro.getUnitPrice()
                + "," + pro.getUnitInStock() + "," + pro.getUnitsOnOrder() + "," + pro.getReorderLevel()
                + "," + pro.getDiscontinued() + ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (Exception e) {
        }
        return n;
    }

    public int insertProductByPrepared(Product pro) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([ProductName]\n"
                + "           ,[SupplierID]\n"
                + "           ,[CategoryID]\n"
                + "           ,[QuantityPerUnit]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitsInStock]\n"
                + "           ,[UnitsOnOrder]\n"
                + "           ,[ReorderLevel]\n"
                + "           ,[Discontinued])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";
//      number of ? = number of field
//index of ? start = 1
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setInt(9, pro.getDiscontinued());
            n = pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public int updateProduct(Product pro) {
        int n = 0;
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[SupplierID] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[QuantityPerUnit] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[UnitsInStock] = ?\n"
                + "      ,[UnitsOnOrder] = ?\n"
                + "      ,[ReorderLevel] = ?\n"
                + "      ,[Discontinued] = ?\n"
                + " WHERE ProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setInt(9, pro.getDiscontinued());
            pre.setInt(10, pro.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public int deleteProduct(int id) {
        int n = 0;
        String sql = "delete Products where ProductID=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);

        } catch (SQLException e) {
        }
        return n;
    }

    public Vector<Product> getProduct(String sql) {
        Vector<Product> vector = new Vector<Product>();
        try {
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ProductID");
                // int id=rs.getInt(1);
                String name = rs.getString(2);
                // String name=rs.getString("ProductName");
                int supid = rs.getInt(3);
                int cateid = rs.getInt(4);
                String perUnit = rs.getString(5);
                double price = rs.getDouble(6);
                int unitIn = rs.getInt(7);
                int unitOut = rs.getInt(8);
                int reOrder = rs.getInt(9);
                int diss = rs.getInt(10);
                Product pro=new Product(
                        id, name, supid, cateid, perUnit, price, unitIn, unitOut, 
                        reOrder, diss);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
        //int n = dao.updateProduct(new Product(79,"proName3", 2, 2, "perUnitDemo1", 101, 2, 2, 2, 0));
//        int n = dao.deleteProduct(80);
//        if (n > 0) {
//            System.out.println("inserted");
//        }
        Vector<Product> vector=dao.getProduct("select * from Products");
        for (Product product : vector) {
            System.out.println(product);
        }
    }
}
