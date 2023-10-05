package Utility;

import java.util.Scanner;

public class Utility implements IUtility {

        @Override
        public int getInt(Scanner sc, String msg, int min, int max) {
                int input = 0;
                do {
                        try {
                                System.out.print(msg);
                                input = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {

                        }
                } while (input < min || input > max);
                return input;

        }

        @Override
        public String getString(Scanner sc, String msg, String pattern) {
                String input;
                do {
                        System.out.print(msg);
                        input = sc.nextLine();
                } while (!input.matches(pattern));
                return input;
        }
}
