import java.util.Scanner;
public class B1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        int sum =0;
        for (int j : a) {
            sum+=j;
        }
        System.out.println(sum);
    }

}
