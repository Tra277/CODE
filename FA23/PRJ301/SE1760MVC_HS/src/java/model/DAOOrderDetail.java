/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOOrderDetail extends DBConnect {

    public int insertOrderDetail(OrderDetail od) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Order Details]\n"
                + "           ([OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[Quantity]\n"
                + "           ,[Discount])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, od.getOrderID());
            ps.setInt(2, od.getProductID());
            ps.setDouble(3, od.getUnitPrice());
            ps.setInt(4, od.getQuantity());
            ps.setDouble(5, od.getDiscount());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }

    public int updateOrderDetail(OrderDetail od) {
        String sql = "UPDATE [dbo].[Order Details]\n"
                + "   SET [UnitPrice] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[Discount] = ?\n"
                + " WHERE OrderID = ? and ProductID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, od.getUnitPrice());
            ps.setInt(2, od.getQuantity());
            ps.setDouble(3, od.getDiscount());
            ps.setInt(4, od.getOrderID());
            ps.setInt(5, od.getProductID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int deleteOrderDetail(int oid,int pid){
        String sql ="DELETE FROM [dbo].[Order Details]\n" +
"      WHERE OrderID = ? and ProductId = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setInt(2, pid);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
        
    }
    public Vector<OrderDetail> getOrderDetail(String sql) throws SQLException{
        Vector<OrderDetail> orderDetailList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            orderDetailList.add(new OrderDetail(rs.getInt("OrderID"),rs.getInt("ProductID")
                    ,rs.getDouble("UnitPrice"),rs.getInt("Quantity"),rs.getDouble("Discount")));
        }
        return orderDetailList;
    }
}
