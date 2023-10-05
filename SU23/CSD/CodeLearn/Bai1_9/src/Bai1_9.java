
import java.util.Scanner;

public class Bai1_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i]=sc.nextInt();
        }
        int[] c = new int[m+n];
        for (int i = 0; i < n; i++) {
            c[i]=a[i];
            
        }
        for (int i = n; i < (n+m); i++) {
            c[i]=b[n+m-i-1];
        }
        
        for (int i = 0; i < m+n; i++) {
            for(int j=i+1;j<m+n;j++){
                if(c[i]>c[j]){
                    int temp=c[i];
                    c[i]=c[j];
                    c[j]=temp;
                            
                }
            }            
        }
        
        for (int i = 0; i < m+n; i++) {
            System.out.print(c[i]+" ");
            
        }
       
    }

}
