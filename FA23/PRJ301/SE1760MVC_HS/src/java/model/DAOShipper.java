/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Shipper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOShipper extends DBConnect {

    public int insertShipper(Shipper s) {
        String sql = "INSERT INTO [dbo].[Shippers]\n"
                + "           ([CompanyName]\n"
                + "           ,[Phone])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getCompanyName());
            ps.setString(2, s.getPhone());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public int updateShipper(Shipper s) {
        String sql = "UPDATE [dbo].[Shippers]\n"
                + "   SET [CompanyName] = ?\n"
                + "      ,[Phone] = ?\n"
                + " WHERE ShipperID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getCompanyName());
            ps.setString(2, s.getPhone());
            ps.setInt(3, s.getShipperID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteShipper(int id) {
        String sql = "DELETE FROM [dbo].[Shippers]\n"
                + "      WHERE ShipperID=" + id;
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public Vector<Shipper> getShipper(String sql) throws SQLException {
        Vector<Shipper> shipperList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            shipperList.add(new Shipper(rs.getInt("ShipperID"), rs.getString("CompanyName"),
                    rs.getString("Phone")
            ));
        }
        return shipperList;
    }
}
