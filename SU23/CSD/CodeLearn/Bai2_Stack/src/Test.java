
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Hiểu về cách Stack hoạt động trong Java và các hàm của nó
        Stack<String> stackChuoi = new Stack<String>();
        //Khá giống push trong Javascript =)))
        //push: đưa giá trị vào stack
        stackChuoi.push("gia tri");
        
        //pop() ==> lấy giá trị ra khỏi stack
        //peek() ==> Trả về phần tử trên cùng của Stack
        //clear(): xóa tất cả phần tử
        //contains("giatri") ==> xác định giá trị có tồn tại trong stack
        //size(): kích thước của Stack
        //Ví dụ đảo ngược chuỗi
        System.out.println("Nhập vào chuỗi: ");
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            stackChuoi.push(s.charAt(i)+"");
            
        }
        System.out.println("Done:");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stackChuoi.pop());   
            
        }
        System.out.println("");
        //Ví dụ chuyển từ hệ thập phân sang hệ nhị phân
        Stack<String> stackSoDu = new Stack<String>();
        System.out.println("Nhập 1 số nguyên dương từ bàn phím:");
        int x = sc.nextInt();
        System.out.println("Số nhị phân là:");
        while(x>0){
            int soDu = x%2;
            stackSoDu.push(soDu+"");
            x=x/2;
        }
        int n = stackSoDu.size();
        for (int i = 0; i < n; i++) {
            System.out.print(stackSoDu.pop());
        }
    }

}
