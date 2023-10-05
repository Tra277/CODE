
import java.util.Scanner;
import java.util.Stack;

public class Bai2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stackString = new Stack<String>();
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            //Sử dụng hàm pop() để thêm phần tử vào xì tách
            stackString.push(s.charAt(i)+"");
        }
        int n = stackString.size();
        for (int i = 0; i < n; i++) {
            System.out.print(stackString.pop());
        }
    }

}
