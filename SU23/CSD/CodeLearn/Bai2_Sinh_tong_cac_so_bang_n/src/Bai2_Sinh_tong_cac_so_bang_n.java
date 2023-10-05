
import java.util.Scanner;

public class Bai2_Sinh_tong_cac_so_bang_n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        boolean notFinal = true;
        int cnt;
    
        //khởi tạo
        cnt = 1;
        a[1]=n;
        
        //In ra và biến đổi
        while(notFinal){
            //In
            for (int i = 1; i <=cnt; i++) {
                System.out.print(a[i]);
                
            }
            System.out.println();
            //bien doi
            int i = cnt;
            while(i>=1 && a[i]==1){
                i--;
            }
            if(i==0){
                notFinal = false;
                
            }else{
                a[i]--;
                //tong so phan tu bo qua
                int d = cnt - i +1;
                //tao tap hop moi
                cnt = i;
                int q = d / a[i];
                int r = d % a[i];
                //them cac phan tu vao tap moi
                if(q!=0){
                    for (int j = 1; j <=q; j++) {
                        cnt++;
                        a[cnt]=a[i];
                    }
                }
                if(r!=0){
                    cnt++;
                    a[cnt]=r;
                }
            }
        }
    }
}
