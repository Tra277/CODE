package GUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ItemList {
    private Item[] list;
    private int numOfItem;
    public static final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    public boolean addItem(Scanner sc, String type) {
        if (numOfItem >= MAX) {
            System.out.println("The list is full. Cannot add more items.");
            return false;
        }
        Item item;
        if (type.equalsIgnoreCase("V")) {
            item = new Vase();
        } else if (type.equalsIgnoreCase("P")) {
            item = new Painting();
        } else {
            System.out.println("Invalid item type. Item not added to the list.");
            return false;
        }
        item.input(sc);
        list[numOfItem++] = item;
        System.out.println("Item added successfully.");
        return true;
    }

    public boolean updateItem(Scanner sc, int index) {
        if (index < 0 || index >= numOfItem) {
            System.out.println("Invalid item index.");
            return false;
        }
        list[index].input(sc);
        System.out.println("Item updated successfully.");
        return true;
    }

    public boolean removeItem(int index) {
        if (index < 0 || index >= numOfItem) {
            System.out.println("Invalid item index.");
            return false;
        }
        for (int i = index; i < numOfItem - 1; i++) {
            list[i] = list[i + 1];
        }
        list[--numOfItem] = null;
        System.out.println("Item removed successfully.");
        return true;
    }

    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("All items:");
        for (int i = 0; i < numOfItem; i++) {
            list[i].output();
        }
    }

    public void displayByType(String type) {
        if (numOfItem == 0) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Items of type " + type + ":");
        for (int i = 0; i < numOfItem; i++) {
            if (list[i] instanceof Vase && type.equalsIgnoreCase("V")) {
                list[i].output();
            } else if (list[i] instanceof Painting && type.equalsIgnoreCase("P")) {
                list[i].output();
            }
        }
    }

    public void sortItem() {
        if (numOfItem == 0) {
            System.out.println("The list is empty.");
            return;
        }
        Arrays.sort(list, 0, numOfItem, new sortByValue());
        System.out.println("The list has been sorted.");
    }

    public void loadFromFile(String filename) {
    File file = new File(filename);
    try {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(";");
            String type = tokens[0];
            Item item;
            if (type.equalsIgnoreCase("V")) {
                item = new Vase();
            } else if (type.equalsIgnoreCase("P")) {
                item = new Painting();
            } else {
                System.out.println("Invalid item type in file. Item not added to the list.");
                continue;
            }
            item.setValue(Integer.parseInt(tokens[1]));
            item.setOrigin(tokens[2]);
            item.setCreator(tokens[3]);
            if (item instanceof Vase) {
                ((Vase) item).setMaterial(tokens[4]);
            } else if (item instanceof Painting) {
                ((Painting) item).setMedium(tokens[4]);
            }
            list[numOfItem++] = item;
        }
        System.out.println("Data loaded successfully from file.");
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename);
    }
    }
}
