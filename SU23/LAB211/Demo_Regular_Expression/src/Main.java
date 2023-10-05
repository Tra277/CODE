
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //VD1: chỉ nhận một số
        
        //VD2: Số có nhiều chữ số
        
        //VD3: nhập số có độ dài lớn hơn 6 kí tự
        //{X,Y} : xuất hiện trong khoảng X tới Y lần
        
        //Khai báo đối tượng thuộc lớp Pattern
        //Regex sẽ bắt đầu với kí tự "^" và kết thúc bằng "$"
        Pattern p = Pattern.compile("^[a-zA-Z0-9 ]{6,}$");
        //sử dụng phương thức .matchers().find() để xem cái txt ở trên có tuân theo format hay không
        while (true) {
            System.out.print("input txt: ");
            String txt = sc.nextLine();
            if (p.matcher(txt).find()) {

                System.out.println("ok nha em");
                break;
            } else {
                System.out.println("txt not ok");
            }
        }

    }

}
