
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
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
    String str1= "English = 78 Science = 83 Math =68 History =65";
    int sum = 0;
    int count = 0;
    String[] parts = str1.split(" ");
        
    // Kiểm tra từng phần ; chuyễn chuối sang số ?
    for (String part : parts) {
            System.out.println(part);
            //Làm sao để chuyển chuỗi sang kiểu số nguyên ?
            //Sử dụng ParseInt và try catch <3 
            try {
                int num = Integer.parseInt(part);
                sum+= num;
                count++;
        } catch (NumberFormatException e) {
        }
        }
    double trungBinhCong = (double) sum / count;
    System.out.println("tONG LÀ:"+sum  );
        System.out.println("Tbc"+trungBinhCong);
    
    }
    
}
