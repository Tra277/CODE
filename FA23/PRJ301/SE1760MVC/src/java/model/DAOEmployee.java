/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Category;
import entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOEmployee extends DBConnect {

    public int insertEmployee(Employee e) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Employees]\n"
                + "           ([LastName]\n"
                + "           ,[FirstName]\n"
                + "           ,[Title]\n"
                + "           ,[TitleOfCourtesy]\n"
                + "           ,[BirthDate]\n"
                + "           ,[HireDate]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[HomePhone]\n"
                + "           ,[Extension]\n"
                + "           ,[Photo]\n"
                + "           ,[Notes]\n"
                + "           ,[ReportsTo]\n"
                + "           ,[PhotoPath])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, e.getLastName());
            pre.setString(2, e.getFirstName());
            pre.setString(3, e.getTitle());
            pre.setString(4, e.getTitleOfCourtesy());
            pre.setDate(5, e.getBirthDate());
            pre.setDate(6, e.getHireDate());
            pre.setString(7, e.getAddress());
            pre.setString(8, e.getCity());
            pre.setString(9, e.getRegion());
            pre.setString(10, e.getPostalCode());
            pre.setString(11, e.getCountry());
            pre.setString(12, e.getHomePhone());
            pre.setString(13, e.getExtenstion());
            pre.setString(14, e.getPhoto());
            pre.setString(15, e.getNotes());
            pre.setInt(16, e.getReportsTo());
            pre.setString(17, e.getPhotoPath());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }

    public int updateEmployee(Employee e) {
        int n = 0;
        String sql = "UPDATE [dbo].[Employees]\n"
                + "   SET [LastName] = ?\n"
                + "      ,[FirstName] = ?\n"
                + "      ,[Title] = ?\n"
                + "      ,[TitleOfCourtesy] = ?\n"
                + "      ,[BirthDate] = ?\n"
                + "      ,[HireDate] = ?\n"
                + "      ,[Address] =?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[HomePhone] = ?\n"
                + "      ,[Extension] = ?\n"
                + "      ,[Photo] = ?\n"
                + "      ,[Notes] = ?\n"
                + "      ,[ReportsTo] = ?\n"
                + "      ,[PhotoPath] = ?\n"
                + " WHERE EmployeeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, e.getLastName());
            pre.setString(2, e.getFirstName());
            pre.setString(3, e.getTitle());
            pre.setString(4, e.getTitleOfCourtesy());
            pre.setDate(5, e.getBirthDate());
            pre.setDate(6, e.getHireDate());
            pre.setString(7, e.getAddress());
            pre.setString(8, e.getCity());
            pre.setString(9, e.getRegion());
            pre.setString(10, e.getPostalCode());
            pre.setString(11, e.getCountry());
            pre.setString(12, e.getHomePhone());
            pre.setString(13, e.getExtenstion());
            pre.setString(14, e.getPhoto());
            pre.setString(15, e.getNotes());
            pre.setInt(16, e.getReportsTo());
            pre.setString(17, e.getPhotoPath());
            pre.setInt(18, e.getEmployeeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }

    public int deleteEmployee(int id) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Employees]\n"
                + "      WHERE EmployeeID=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);

        } catch (SQLException e) {
        }
        return n;
    }

    public Vector<Employee> getEmployeetBySQL(String sql) throws SQLException {
        Vector<Employee> employeeList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            employeeList.add(new Employee(rs.getInt("EmployeeID"), rs.getString("LastName"),
                    rs.getString("FirstName"), rs.getString("Title"), rs.getString("TitleOfCourtesy"),
                    rs.getDate("BirthDate"), rs.getDate("HireDate"), rs.getString("Address"),
                    rs.getString("City"), rs.getString("Region"),
                    rs.getString("PostalCode"), rs.getString("Country"), rs.getString("HomePhone"),
                    rs.getString("Extension"), rs.getString("Photo"), rs.getString("Notes"),
                    rs.getInt("ReportsTo"), rs.getString("PhotoPath")));
        }
        return employeeList;
    }
}
