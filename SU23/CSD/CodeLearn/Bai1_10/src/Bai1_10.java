
import java.util.Scanner;

public class Bai1_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]= sc.nextInt();
            }            
        }        
        int sum=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum+=a[i][j];                
            }            
        }
        System.out.print(sum);
    }

}
