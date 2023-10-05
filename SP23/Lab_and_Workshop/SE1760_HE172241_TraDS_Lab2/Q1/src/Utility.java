
import java.util.Scanner;

public class Utility {
   public float GetFloat(Scanner sc, String msg, float min, float max) {
      float input;
      while (true) {
         System.out.print(msg);
         input = sc.nextFloat();
         if (input >= min && input <= max) {
            break;
         }
         
      }
      return input;
   }
}
