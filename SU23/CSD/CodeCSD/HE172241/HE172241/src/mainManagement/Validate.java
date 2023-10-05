package mainManagement;


import java.io.IOException;
import java.util.Scanner;

public class Validate {

    static Scanner scanner = new Scanner(System.in);

    public int getInt(String msg, String err, int condition) {
        System.out.print(msg);
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < condition) {
                    System.out.println(err);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer!!");
            }
        }
    }

    public double getDouble(String msg, String err, double condition) {
        System.out.println(msg);
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < condition ) {
                    System.out.println(err);
                } else {
                    return value;
                }
            } catch (Exception e) {
            }

        }
    }

    public String getString(String regex, String msg) {
        System.out.print(msg);
        while (true) {
            String value = scanner.nextLine();
            if (value.matches(regex)) {
                return value;
            } else {
                System.out.println("you enter wrong pattern!");
            }
        }
    }
}
