package model;

import java.util.Scanner;

public class Validation {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        //hoan doi neu nguoi min > max
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        while (true) {
            try {
                System.out.println(msg);
                int value = Integer.parseInt(scanner.nextLine());
                if (min <= value && value >= max) {
                    return value;
                }
                System.out.println("Please input a number in range ");
            } catch (Exception e) {
                System.out.println("Wrong Format!");
            }
        }
    }

    public static String getString(String msg) {
        while (true) {
            System.out.println(msg);
            String s = scanner.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Empty string is not allowed!");
        }
    }

    public static boolean getYN(String msg) {
        while (true) {
            System.out.println(msg);
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("y")) {
                return true;
            } else if (s.equalsIgnoreCase("n")){
                return false;
            }
        }
    }
}
