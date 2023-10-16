/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.EmployeeTerritory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOEmployeeTerritory extends DBConnect {

    public int insertEmployeeTerritory(EmployeeTerritory et) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[EmployeeTerritories]\n"
                + "           ([EmployeeID]\n"
                + "           ,[TerritoryID])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, et.getEmployeeID());
            ps.setString(2, et.getTerritoryID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //UPDATE không phù hợp trong sử dụng các bảng với mối quan hệ nhiều nhiều
    //ta có thể sử dụng kết hợp delete và insert thay cho update 
    public int deleteEmployeeTerritory(int eid, String tid) {
        String sql = "DELETE FROM [dbo].[EmployeeTerritories]\n"
                + "      WHERE EmployeeID = ? and TerritoryID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, eid);
            ps.setString(2, tid);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public Vector<EmployeeTerritory> getEmployeeTerritory(String sql) {
        Vector<EmployeeTerritory> etList = new Vector<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etList.add(new EmployeeTerritory(rs.getInt("EmployeeID"), rs.getString("TerritoryID")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return etList;
    }

}
