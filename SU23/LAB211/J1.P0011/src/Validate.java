
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Validate {

    private final static Scanner in = new Scanner(System.in);

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input number binary
    public static String checkInputBinary() {
        System.out.print("Enter number binary: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches("[0-1.]*")) {
                
                    return result;
                
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Enter again: ");
        }
    }

    //    //check user input number binary
    public static double checkInputDecimal() {
        System.out.print("Enter number decimal: ");
        double result;
        //loop until user input correct
        while (true) {
            try {
                result = Double.parseDouble(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must enter a decimal number");
                System.out.print("Enter again: ");
            }
        }
    }

    //    //check user input number binary
    public static String checkInputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim();
            if (result.matches("[0-9a-fA-F.]*")) {
                    return result.toUpperCase();
                
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.print("Enter again: ");
        }
    }
}
