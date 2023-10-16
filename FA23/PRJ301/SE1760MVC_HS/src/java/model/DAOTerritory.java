/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Territory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author alexf
 */
public class DAOTerritory extends DBConnect {

    public int insertTerritory(Territory t) {
        String sql = "INSERT INTO [dbo].[Territories]\n"
                + "           ([TerritoryID]\n"
                + "           ,[TerritoryDescription]\n"
                + "           ,[RegionID])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTerritoryID());
            ps.setString(2, t.getTerritoryDiscription());
            ps.setInt(3, t.getRegionID());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public int updateTerritory(Territory t) {
        String sql = "UPDATE [dbo].[Territories]\n"
                + "   SET [TerritoryDescription] = ?\n"
                + "      ,[RegionID] = ?\n"
                + " WHERE TerritoryID = ?";
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTerritoryDiscription());
            ps.setInt(2, t.getRegionID());
            ps.setString(3, t.getTerritoryID());
            
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteTerritory(String id) {
        String sql = "DELETE FROM [dbo].[Territories]\n"
                + "      WHERE TerritoryID=" + id;
        int n = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    public Vector<Territory> getTerritory(String sql) throws SQLException {
        Vector<Territory> territoryList = new Vector<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            territoryList.add(new Territory( rs.getString("TerritoryID"),
                    rs.getString("TerritoryDescription"), rs.getInt("RegionID")));
        }
        return territoryList;
    }
}
