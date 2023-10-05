
import DTO.Item;
import DTO.Painting;
import DTO.Vase;
import Utility.Utility;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item item = null;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Create a Vase:");
        System.out.println("2. Create a Painting:");
        Utility utility = new Utility();
        choice = utility.getInt(sc, "Enter choice (1-2):", 1, 2);
        switch (choice) {
            case 1:
                item = new Vase();
                item.input(sc);
                break;
            case 2:
                item = new Painting();
                item.input(sc);
                break;
        }
        if (item != null) {
            System.out.println("OUTPUT:");
        if (item instanceof Vase) {
            System.out.println("Vase's information:");
            item.output();
        } else if (item instanceof Painting) {
            System.out.println("Painting's information:");
            item.output();
        }
        } else {
            System.out.println("You need to create an object");
        }
        }
}
