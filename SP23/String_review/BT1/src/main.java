
import java.util.Scanner;


/**
 *
 * @author alexf
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào đmm:");
        String s1 = sc.nextLine();
        
        
        int demSo =0;
        int demUpCase =0;
        int demLowCase =0;
        int demSpace =0;
        for(int i=0;i<s1.length();i++){
           char c = s1.charAt(i);
           if(Character.isDigit(c)){
               demSo ++;
           }
           if (Character.isLowerCase(c)){
               demLowCase++;
           }
           if (Character.isUpperCase(c)){
               demUpCase++;
           }
           if (Character.isSpace(c)){
               demSpace++;
           }
        }
        System.out.println(demSo+" "+demLowCase+" "+demSpace+" "+demUpCase);
        
        
    
    
}
}