import java.util.Scanner;

public class Part2_2 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String string;
      
      do {
         System.out.print("Enter a string: ");
         string = input.nextLine();
         try {
            if (!string.matches("SE\\d{3}")) {
               throw new Exception("The string is invalid");
            }
            System.out.println("The string is: " + string);
            break;
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      } while (true);
      input.close();
   }
}