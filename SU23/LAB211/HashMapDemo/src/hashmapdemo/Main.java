//A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).
//One object is used as a key (index) to another object (value). It can store different types: String keys and Integer values, or the same type, like: String keys and String values:
package hashmapdemo;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //Creat a hashmap that will store String keys and String values
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        //Add items - put() method
        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        //Access an item - get() method 
        capitalCities.get("England");// trỏ đến London;
        System.out.println(capitalCities.get("England"));

        //remove an item - remove() method 
        //remove all item - clear()
        capitalCities.remove("USA");
        System.out.println(capitalCities);

        //size()
        System.out.println(capitalCities.size());

        //Look through a hashmap
        //Use the keySet() method if you only want the keys, and use the values() method if you only want the values
        //print keys
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        
        //print values
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }
        

        // Print keys and values
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }

    }

}
