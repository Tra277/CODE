/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOCategory extends DBConnect {

    public int insertCategory(Category c) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([CategoryName]\n"
                + "           ,[Description]\n"
                + "           ,[Picture])\n"
                + "     VALUES\n"
                + "           (?,?,null)";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCategoryName());
            ps.setString(2, c.getDescription());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public int updateCategory(Category c) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [CategoryName] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[Picture] = null\n"
                + " WHERE CategoryID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCategoryName());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getCategoryID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;   
    }
    public int deleteCategory(int id){
        String sql ="DELETE FROM [dbo].[Categories]\n" +
"      WHERE CategoryID="+id;
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
        
    }
    public Vector<Category> getCategory(String sql) throws SQLException{
        Vector<Category> productList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            productList.add(new Category(rs.getInt("CategoryID"),rs.getString("CategoryName")
                    ,rs.getString("Description"),rs.getString("Picture")));
        }
        return productList;
    }
}
