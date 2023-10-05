package Manager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create a list to store Country objects
        ArrayList<Country> countryList = new ArrayList<>();
        
        // Loop until the user chooses to exit
        while (true) {
            // Display the menu and get the user's choice
            int choice = ManageEastAsiaCountries.menu();
            
            // Perform the appropriate action based on the user's choice
            switch (choice) {
                case 1:
                    // Input a new country
                    ManageEastAsiaCountries.inputCountry(countryList);
                    break;
                case 2:
                    // Print the list of countries
                    ManageEastAsiaCountries.printCountry(countryList);
                    break;
                case 3:
                    // Search for a country by name
                    ManageEastAsiaCountries.searchByName(countryList);
                    break;
                case 4:
                    // Print the list of countries sorted by name
                    ManageEastAsiaCountries.printCountrySorted(countryList);
                    break;
                case 5:
                    // Exit the program
                    return;
            }
        }
    }
}