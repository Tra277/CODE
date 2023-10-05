
import java.util.Scanner;

public class Bai1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }        
        int k=sc.nextInt();
        //Mấy bài kiểu này phải để ý vòng lặp hợp lý để k bị mất giá trị các element
        for(int i=k;i<n-1;i++){
            a[i]=a[i+1];
        }
        n--;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

}
