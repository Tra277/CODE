//PHương pháp sinh
import java.util.Scanner;

public class Bai2_Giai_Thuat_Sinh_Nhi_Phan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        boolean notFinal = true;
        
        
        //Khởi tạo
        for (int i = 1; i <= n; i++) {
            a[i]=0;
        }
        
        //In ra và biến đổi
        while(notFinal){
            //In ra dãy bit trước đó
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            //Phương pháp sinh (biến đổi)
            int i =n;
            while(i>=0 && a[i]==1){
                a[i]=0;
                i--;
            }
            if(i==0){
                notFinal = false;
            }else{
                a[i]=1;
            }
            //===> Ra một dãy bit mới
        }    
    }

}
