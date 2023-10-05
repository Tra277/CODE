//PHương pháp sinh tập con k phần tử của tập hợp n phần tử
import java.util.Scanner;

public class Bai2_Sinh_tap_con {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        boolean notFinal=true;
        int k = sc.nextInt();
        
        //Khởi tạo cấu hình đầu tiên
        for (int i = 1; i <=k; i++) {
           a[i]=i;
           
        }
        
        //In ra và biến đổi
        while (notFinal) {
            //In ra 
            for (int i = 1; i <= k; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            //Biến đổi(phương pháp sinh)
            int i = k;
            while(i>=1 && a[i]==n-k+i){
                i--;
            }
            if(i==0){
                notFinal=false;
            }
            else{
                a[i]++;
                for (int j = i+1; j <=k; j++) {
                    a[j]=a[j-1]+1;
                }
            }
            
        }
    }

}
