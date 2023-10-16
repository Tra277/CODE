/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOOrder extends DBConnect {

    public int insertOrder(Order o) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, o.getCustomerID());
            ps.setInt(2, o.getEmployeeID());
            ps.setDate(3, o.getOrderDate());
            ps.setDate(4, o.getRequiredDate());
            ps.setDate(5, o.getShippedDate());
            ps.setInt(6, o.getShipVia());
            ps.setDouble(7, o.getFreight());
            ps.setString(8, o.getShipName());
            ps.setString(9, o.getShipAddress());
            ps.setString(10, o.getShipCity());
            ps.setString(11, o.getShipRegion());
            ps.setString(12, o.getShipPostalCode());
            ps.setString(13, o.getShipCountry());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }

    public int updateOrder(Order o) {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[EmployeeID] = ?\n"
                + "      ,[OrderDate] = ?\n"
                + "      ,[RequiredDate] = ?\n"
                + "      ,[ShippedDate] = ?\n"
                + "      ,[ShipVia] = ?\n"
                + "      ,[Freight] = ?\n"
                + "      ,[ShipName] = ?\n"
                + "      ,[ShipAddress] = ?\n"
                + "      ,[ShipCity] = ?\n"
                + "      ,[ShipRegion] = ?\n"
                + "      ,[ShipPostalCode] = ?\n"
                + "      ,[ShipCountry] = ?\n"
                + " WHERE OrderID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, o.getCustomerID());
            ps.setInt(2, o.getEmployeeID());
            ps.setDate(3, o.getOrderDate());
            ps.setDate(4, o.getRequiredDate());
            ps.setDate(5, o.getShippedDate());
            ps.setInt(6, o.getShipVia());
            ps.setDouble(7, o.getFreight());
            ps.setString(8, o.getShipName());
            ps.setString(9, o.getShipAddress());
            ps.setString(10, o.getShipCity());
            ps.setString(11, o.getShipRegion());
            ps.setString(12, o.getShipPostalCode());
            ps.setString(13, o.getShipCountry());
            ps.setInt(14, o.getOrderID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }
    public int deleteOrder(int id){
        String sql ="DELETE FROM [dbo].[Orders]\n" +
"      WHERE OrderID = "+id;
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
        
    }
    public Vector<Order> getOrder(String sql) throws SQLException{
        Vector<Order> orderList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            orderList.add(new Order(rs.getInt("OrderID"),
                    rs.getString("CustomerID"),
            rs.getInt("EmployeeID"),
            rs.getDate("OrderDate"),
            rs.getDate("RequiredDate"),
            rs.getDate("ShippedDate"),
            rs.getInt("ShipVia"),
            rs.getDouble("Freight"),
            rs.getString("ShipName"),
            rs.getString("ShipAddress"),
            rs.getString("ShipCity"),
            rs.getString("ShipRegion"),
            rs.getString("ShipPostalCode"),
            rs.getString("ShipCountry")
            ));
        }
        return orderList;
    }
}
