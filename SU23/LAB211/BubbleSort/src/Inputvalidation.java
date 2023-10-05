
import java.util.Scanner;


public class Inputvalidation {
    private static Scanner sc = new Scanner(System.in);
    static int getArrayLength(){
        int param;
        while (true) {
            
            try {
                 param = Integer.parseInt(sc.nextLine());
                if(param<0){
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please Enter positive Integer:");
            }
            
        }
        return param;
    }
    static int getElement(){
        int param;
        while (true) {
            
            try {
                 param = Integer.parseInt(sc.nextLine());
                 break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number:");
            }
        }
        return param;
    }
}
