
import java.util.Scanner;

public class B1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        
        for (int j : a) {
            System.out.print(j*j);
            System.out.print(" ");
        }
       
    }

}
