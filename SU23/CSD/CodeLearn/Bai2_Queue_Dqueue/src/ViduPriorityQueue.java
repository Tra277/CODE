
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ViduPriorityQueue {
    public static void main(String[] args) {
        Queue<String> danhSachSV = new PriorityQueue<String>();
        //Khác với Queue là một lần add vào queue thì nó sẽ sắp xếp tăng dần(có thể tùy chỉnh điều kiện sắp xếp bằng Comparator or Comparable
        danhSachSV.offer("TITV1");
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
