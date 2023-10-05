package GUI;

import java.util.Scanner;

/**
 *
 * @author alexf
 */
public interface IList {
    void loadFromFile(String fileName);
    void saveToFile(String fileName);
    void addEdit(Scanner sc);
    void display();
}
