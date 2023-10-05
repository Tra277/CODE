
import java.util.Scanner;

public class Bai2_Sinh_hoan_vi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        boolean notFinal = true;
        
        //khởi tạo cấu hình đầu tiên
        for (int i = 1; i <= n; i++) {
            a[i]=i;
        }
        
        //in ra và biến đổi
        while(notFinal){
            //in ra
            for (int i = 1; i <=n; i++) {
                System.out.print(a[i]);
                
            }
            System.out.println();
            //biến đổi
            int i = n-1;
            //tìm thằng a[i]<a[i+1]
            while(i>=1 && a[i]>a[i+1]){
                --i;
            }
            if(i==0){
                notFinal=false;
            }
            else{
                //Tìm thằng nhỏ nhất lớn hơn a[i]
                int j=n;
                while(a[i]>a[j]){
                    --j;
                }
                //Tìm thấy rồi thì swap hai thằng này cho nhau
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
                
                //Lật ngược vị trí từ a[i+1] --> a[n]
                int l=i+1;int r=n;
                while (l<r) {                    
                    int tg = a[l];
                    a[l]=a[r];
                    a[r]=tg;
                    l++;r--;
                }
              
            }
            
        }
       

    }

}
