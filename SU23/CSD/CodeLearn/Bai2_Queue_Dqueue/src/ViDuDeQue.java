
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ViDuDeQue {
    public static void main(String[] args) {
        //Deque ở đây nó lại một Interface riêng, Không kế thừa tử Queue
        //Linh hoạt hơn bằng cách thêm vào đầu hoặc cuối
        Deque<String> danhSachSV = new ArrayDeque<String>();
        danhSachSV.offer("TIVT1");
        danhSachSV.offer("TIVT");
        danhSachSV.offer("hello");
        danhSachSV.offer("TITV2");
        danhSachSV.offerFirst("TITV3");
        danhSachSV.offerFirst("TITV4");
        
        while (true) {            
            String ten = danhSachSV.poll();
            if(ten==null){
                break;
            }
            System.out.println(ten);
        }
    }

}
