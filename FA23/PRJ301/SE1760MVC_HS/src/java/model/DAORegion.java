/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Region;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAORegion extends DBConnect {

    public int insertRegion(Region r) {
        String sql = "INSERT INTO [dbo].[Region]\n"
                + "           ([RegionID]\n"
                + "           ,[RegionDescription])\n"
                + "     VALUES\n"
                + "           (?,?)";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, r.getRegionID());
            ps.setString(2, r.getRegionDescription());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public int updateRegion(Region r) {
        String sql = "UPDATE [dbo].[Region]\n"
                + "   SET [RegionDescription] = ?\n"
                + " WHERE RegionID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, r.getRegionDescription());
            ps.setInt(2, r.getRegionID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int deleteRegion(int id){
        String sql ="DELETE FROM [dbo].[Region]\n" +
"      WHERE RegionID="+id;
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
        
    }
    public Vector<Region> getRegion(String sql) throws SQLException{
        Vector<Region> regionList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            regionList.add(new Region(rs.getInt("RegionID"),rs.getString("RegionDescription")));
        }
        return regionList;
    }
}
