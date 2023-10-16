/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOSupplier extends DBConnect {

    public int insertSupplier(Supplier s) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Suppliers]\n"
                + "           ([CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax]\n"
                + "           ,[HomePage])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getCompanyName());
            ps.setString(2, s.getContactName());
            ps.setString(3, s.getContactTitle());
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getCity());
            ps.setString(6, s.getRegion());
            ps.setString(7, s.getPostalCode());
            ps.setString(8, s.getCountry());
            ps.setString(9, s.getPhone());
            ps.setString(10, s.getFax());
            ps.setString(11, s.getHomePage());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }

    public int updateSupplier(Supplier s) {
        String sql = "UPDATE [dbo].[Suppliers]\n"
                + "   SET [CompanyName] = ?\n"
                + "      ,[ContactName] = ?\n"
                + "      ,[ContactTitle] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Fax] = ?\n"
                + "      ,[HomePage] = ?\n"
                + " WHERE SupplierID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getCompanyName());
            ps.setString(2, s.getContactName());
            ps.setString(3, s.getContactTitle());
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getCity());
            ps.setString(6, s.getRegion());
            ps.setString(7, s.getPostalCode());
            ps.setString(8, s.getCountry());
            ps.setString(9, s.getPhone());
            ps.setString(10, s.getFax());
            ps.setString(11, s.getHomePage());
            ps.setInt(12, s.getSupplierID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }

    public int deleteSupplier(int id) {
        String sql = "DELETE FROM [dbo].[Suppliers]\n"
                + "      WHERE SupplierID = " + id;
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public Vector<Supplier> getSupplier(String sql) throws SQLException {
        Vector<Supplier> supplierList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            supplierList.add(new Supplier(rs.getInt("SupplierID"),rs.getString("CompanyName"),
                    rs.getString("ContactName"),
                    rs.getString("ContactTitle"),
                    rs.getString("Address"),
                    rs.getString("City"),
                    rs.getString("Region"),
                    rs.getString("PostalCode"),
                    rs.getString("Country"),
                    rs.getString("Phone"),
                    rs.getString("Fax"),
                    rs.getString("HomePage")
                    ));
        }
        return supplierList;
    }
}
