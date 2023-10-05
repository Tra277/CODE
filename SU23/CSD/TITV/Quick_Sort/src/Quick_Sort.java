
import java.util.Scanner;

public class Quick_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        Quick_Sort.hoandoi(a,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }
    //Nếu mình nhớ là hoàn đổi ngoài hàm thì phải dùng con trỏ, nhưng mình vẫn chưa đụng cái này ở trong Java, không thì là xong rồi T.T
    private static void hoandoi(int[] a, int indexLeft, int indexRight) {
        int m = indexLeft;
        int n = indexRight;
        int pivot = a[indexLeft];
        while(m<=n){
            if(m==n){
                a[m]=pivot;
                break;
            }
            while (a[m]>=pivot && n>m) {
                n--;
                
            }
            int tem = a[m];
            a[m]=a[n];
            a[n]=tem;
            
            while (a[m]<=pivot && m<n) {
                m++;
                
            }
            int temp = a[m];
            a[m]=a[n];
            a[n]=temp;
            
            
        }
        
        if(indexLeft!=indexRight){
            hoandoi(a, indexLeft, m-1);            
            hoandoi(a, m+1,indexRight-1 );
        }
        
    }

}
// Bài này không chạy được nên mình sẽ hỏi chatGPT và cho nó chạy ở Quick_Sort2