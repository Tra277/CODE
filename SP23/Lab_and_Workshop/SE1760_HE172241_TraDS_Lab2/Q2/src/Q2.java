import java.util.Scanner;
import java.util.Locale;
public class Q2 {
    public static void main(String[] args) {
        String id, name;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); 
        Utility u = new Utility();
        id = u.GetString(sc, "Enter student id (HE123456):", "^HE\\d{6}$");
        name = u.GetString(sc, "Enter name (NOT EMPTY):", "^.+$");
        System.out.println("OUTPUT");
        System.out.println(id);
        System.out.println(name);
    }
}