/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexf
 */
public class CategoryDAO extends DBContext {

    //doc tat ca cac ban ghi tu table Category
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"),
                        rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    //add a category
    public void insert(Category category) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([ID]\n"
                + "           ,[name]\n"
                + "           ,[describe])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescribe());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //tim category by id
    public Category getCategoryById(int id) {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"),
                        rs.getString("describe"));
                return c;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    //xoa category by ID
    public void delete(int id) {
        String sql = "delete from Categories where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update category
    public void update(Category c) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [name] = ?\n"
                + "      ,[describe] = ?\n"
                + " WHERE ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2,c.getDescribe());
            ps.setInt(3,c.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Category> list = c.getAll();
        System.out.println(list.get(1).getName());
    }
}
