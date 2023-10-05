
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class ViDuQueue {
    public static void main(String[] args) {
      Scanner sc =new Scanner(System.in);
        //Ta có thể sử dụng LinkedList để đại diện cho Queue và dùng các hàm cho queue bình thường
        //Offer:Giống push();
        //poll:Giống pop
        Queue<String> danhSachSV = new LinkedList<String>();
        danhSachSV.offer("TIVT");
        danhSachSV.offer("hello");
        danhSachSV.offer("TITV2");
        
        while (true) {            
            String ten = danhSachSV.poll();
            if(ten==null){
                break;
            }
            System.out.println(ten);
        }
    }

}
