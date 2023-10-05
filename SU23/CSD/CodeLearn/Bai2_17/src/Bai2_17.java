
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai2_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> numberList = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            numberList.offer(a);
        }
        int k = sc.nextInt();
        for (int i = 1; i <=k; i++) {
            int a = numberList.poll();
            numberList.offer(a);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(numberList.poll()+" ");
        }
    }

}
