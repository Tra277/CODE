
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;



public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String password= "";
        While(true){
        System.out.println("MK:");
        String newPassword = sc.nextLine();
        //Kiểm tra tính hợp lệ
        if(checkMk(newPassword)){
            password = newPassword;
            System.out.println("Hop le");
            
        }else{
            System.out.println("Again");
        }
    }
        
    }
    public static boolean checkMk(String password){
        //Kiểm tra độ dài
        if (password.length()<6){
            return false;
        }
        //Kiểm tra xem có chứa chữ cái không ?
        boolean hasLetter = false;
        for (char c :password.toCharArray()){
            if(Character.isLetter(c)){
                hasLetter = true;
                break;
            }
            
        }
        if(!hasLetter){
            return false;
        }
        // Kiểm tra xem mật khẩu có chứa ít nhất 1 chữ số hay không
        boolean hasNumber = false;
        for (char c :password.toCharArray()){
            if(Character.isDigit(c)){
                hasLetter = true;
                break;
            }
            
        }
        if(!hasNumber){
            return false;
        }
        return true;
    }
}
