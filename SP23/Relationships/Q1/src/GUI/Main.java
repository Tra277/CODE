package GUI;

import DTO.Item;
import DTO.Painting;
import DTO.Vase;
import Utility.Utility;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        int choice, index;
        Scanner sc = new Scanner(System.in);
        Utility u = new Utility();
        System.out.println("1. Display all items from file items.txt");
        System.out.println("2. Add a vase and display all vases");
        System.out.println("3. Add a painting and display all paintings");
        System.out.println("4. Remove a item and display all items");
        System.out.println("5. Sort items by the ascending order of value and display all items");
        choice = u.getInt(sc, "Enter your choice (1-5):", 1, 5);
        
        ItemList il = new ItemList();
        il.loadFromFile("C:\\JAVA\\items.txt");
        switch(choice)
            {
                case 1:
                    // display all item from file
                    System.out.println("OUTPUT:");
                    il.displayAll();
                    break;
                case 2:
                    // add a Vase and display Vases
                    il.addItem(sc, "Vase");
                    System.out.println("OUTPUT:");
                    il.displayItemByType("Vase");
                    break;
                case 3:
                    // add a painting and display Paintings
                    il.addItem(sc, "Painting");
                    System.out.println("OUTPUT:");
                    il.displayItemByType("Painting");
                    break;
                case 4:
                    // remove and diiplay all items
                    index = u.getInt(sc, String.format("Enter index (0-%d):", il.getNumOfItem()-1), 0, il.getNumOfItem()-1);
                    System.out.println("OUTPUT:");
                    if(il.removeItem(index))
                        il.displayAll();
                    break;
                case 5:
                    // sort by Value and display all items
                    System.out.println("OUTPUT:");
                    il.sortItem();
                    break;                
            }
    }
}
