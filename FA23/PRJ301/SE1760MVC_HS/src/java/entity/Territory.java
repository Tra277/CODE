/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author alexf
 */
public class Territory {
    private String territoryID;
    private String territoryDiscription;
    private int RegionID;

    public Territory() {
    }

    public Territory(String territoryID, String territoryDiscription, int RegionID) {
        this.territoryID = territoryID;
        this.territoryDiscription = territoryDiscription;
        this.RegionID = RegionID;
    }

    public String getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(String territoryID) {
        this.territoryID = territoryID;
    }

    public String getTerritoryDiscription() {
        return territoryDiscription;
    }

    public void setTerritoryDiscription(String territoryDiscription) {
        this.territoryDiscription = territoryDiscription;
    }

    public int getRegionID() {
        return RegionID;
    }

    public void setRegionID(int RegionID) {
        this.RegionID = RegionID;
    }

    
}
