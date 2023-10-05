package Manager;

public class EastAsiaCountries {

    // Instance variables to store the code, name, and area of the country
    protected String countryCode;
    protected String countryName;
    protected double countryArea;

    // Default constructor
    public EastAsiaCountries() {
    }

    // Constructor with parameters
    public EastAsiaCountries(String countryCode, String countryName, double countryArea) {
        // Set the instance variables with the values of the parameters
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
    }

    // Getter method for the countryCode instance variable
    public String getCountryCode() {
        return countryCode;
    }

    // Setter method for the countryCode instance variable
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    // Getter method for the countryName instance variable
    public String getCountryName() {
        return countryName;
    }

    // Setter method for the countryName instance variable
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    // Getter method for the countryArea instance variable
    public double getCountryArea() {
        return countryArea;
    }

    // Setter method for the countryArea instance variable
    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    // Method to display information about the country
    public void display() {
        // This method is empty and can be overridden in subclasses
    }
}
