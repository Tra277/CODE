
import java.util.Scanner;
import java.util.Stack;

public class Bai2_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stackString = new Stack<String>();
        int x = sc.nextInt();
        while(x>0){
            int soDu = x%2;
            stackString.push(soDu+"");
            x/=2;
        }
        int n = stackString.size();
        for (int i = 0; i < n; i++) {
            System.out.print(stackString.pop());
        }
    }

}
