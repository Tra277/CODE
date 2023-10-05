import java.util.Scanner;
import java.util.Locale;

public class Q1 {
   public static void main(String[] args) {
      float marks = 0;
      
      Scanner sc = new Scanner(System.in);
      sc.useLocale(Locale.US); 
      Utility u = new Utility();
      marks = u.GetFloat(sc, "Enter marks (0-10):", 0, 10);
      System.out.println("OUTPUT");
      System.out.format("%3.1f", marks);
   }
}