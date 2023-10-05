import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    public String GetString(Scanner sc, String msg, String pattern) {
        String str = "";
        do {
            System.out.print(msg);
            str = sc.nextLine();
            if (!Pattern.matches(pattern, str)) {
                System.out.print("");
            }
        } while (!Pattern.matches(pattern, str));
        return str;
    }
}