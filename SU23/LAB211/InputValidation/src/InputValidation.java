
import java.util.Scanner;

public class InputValidation {

    private static Scanner sc = new Scanner(System.in);

    public static void getInt() {
        int param;
        //check input co phai la so nguyen hay khong 
        while (true) {
            try {
                param = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Vui long nhap mot so nguyen:");
            }
        }
        System.out.println(param);
        //Double nó khác Integer ở chỗ là mình chỉ cần thay bằng Double.parseDouble là được
    }
    
    //check input String
    public static String GetString(){
        String name;
        System.out.println("Please input Name:");
        while (true) {            
            name = sc.nextLine().trim();
            if(!name.equals("")){
                break;
            }else{
                System.out.println("Name must be character:");
            }
        }
        return name;
    }
    public static void main(String[] args) {

        System.out.println("Please enter a number:");
        String name = GetString();
        
        System.out.println(name);
    }

}
