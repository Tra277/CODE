/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author alexf
 */
public class DAO extends DBContext {

    //lay du lieu category
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

    //doc tu bang product theo cid
    public List<Product> getProductsByCid(int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[name]\n"
                + "      ,[quantity]\n"
                + "      ,[price]\n"
                + "      ,[releaseDate]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[cid]\n"
                + "  FROM [dbo].[products]\n";
        if(cid!=0){
            sql=sql+ " where cid = "+cid;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product p = new Product(rs.getString("id"),rs.getString("name")
                        ,rs.getInt("quantity") ,rs.getDouble("price")
                        , rs.getString("releaseDate"), rs.getString("describe")
                        , rs.getString("image"), getCategoryById(rs.getInt("cid")));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
