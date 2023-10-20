/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Customer;
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
public class DAOCustomer extends DBConnect {

    public int insertCustomerByPrepared(Customer cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([CustomerID]\n"
                + "           ,[CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//      number of ? = number of field
//index of ? start = 1
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerId());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getContactName());
            pre.setString(4, cus.getContactTitle());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getRegion());
            pre.setString(8, cus.getPostalCode());
            pre.setString(9, cus.getCountry());
            pre.setString(10, cus.getPhone());
            pre.setString(11, cus.getFax());
            n = pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public int updateCustomer(Customer cus) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers]\n"
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
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCompanyName());
            pre.setString(2, cus.getContactName());
            pre.setString(3, cus.getContactTitle());
            pre.setString(4, cus.getAddress());
            pre.setString(5, cus.getCity());
            pre.setString(6, cus.getRegion());
            pre.setString(7, cus.getPostalCode());
            pre.setString(8, cus.getCountry());
            pre.setString(9, cus.getPhone());
            pre.setString(10, cus.getFax());
            pre.setString(11, cus.getCustomerId());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteCustomer(String id) {
        int n = 0;
        String sql = "DELETE FROM Customers WHERE CustomerID = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý hoặc ghi log lỗi tại đây
            e.printStackTrace();
        }
        return n;
    }
    
    public Vector<Customer> getCustomer(String sql) {
        Vector<Customer> vector = new Vector<Customer>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String id=rs.getString("CustomerID");
                String companyName = rs.getString("CompanyName");
                String contactName = rs.getString(3);
                String contactTitle = rs.getString(4);
                String address = rs.getString(5);
                String city = rs.getString(6);
                String region = rs.getString(7);
                String postalCode = rs.getString(8);
                String country = rs.getString(9);
                String phone = rs.getString(10);
                String fax = rs.getString(11);
                Customer cus=new Customer(id, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOCustomer daoCustomer = new DAOCustomer();
//        int n = daoCustomer.insertCustomerByPrepared(new Customer("VIETN", "Sun House",
//                 "Paul Bayment", "Administrator", "129 Dinh La Thang", "Ha Noi", "VN", "10000",
//                 "Viet Nam", "0912345161", "123456789"));
//        int n = daoCustomer.updateCustomer(new Customer("VIETN", "Sun House1",
//                 "Paul Bayment1", "Administrator1", "129 Dinh La Thang1", "Ha Noi1", "VN1", "100001",
//                 "Viet Nam1", "09123451611", "1234567891"));
//        int n = daoCustomer.deleteCustomer("VIETN");
//        
//        if (n > 0) {
//            System.out.println("inserted");
//        }
        
        Vector<Customer> vector = daoCustomer.getCustomer("select * from Customers where CustomerID = 'AYENL'");
        for (Customer customer : vector) {
            System.out.println(customer);
        }
    }
}
