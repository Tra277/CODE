package Manager;

public class Country extends EastAsiaCountries implements Comparable<Country> {

    // Instance variable to store the terrain of the country
    private String countryTerrain;

    // Default constructor
    public Country() {
    }

    // Constructor with parameters
    public Country(String countryTerrain, String countryCode, String countryName, double countryArea) {
        // Call the constructor of the superclass
        super(countryCode, countryName, countryArea);
        // Set the terrain of the country
        this.countryTerrain = countryTerrain;
    }

    // Override the display method to include the terrain of the country
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.countryCode,
                this.countryName, this.countryArea, this.countryTerrain);
    }

    // Getter method for the countryTerrain instance variable
    public String getCountryTerrain() {
        return countryTerrain;
    }

    // Setter method for the countryTerrain instance variable
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    // Override the compareTo method to compare countries by name
    @Override
    public int compareTo(Country t) {
        return this.getCountryName().compareTo(t.getCountryName());
    }
}