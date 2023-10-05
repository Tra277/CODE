
import java.util.Scanner;

public class Bai1_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            
        }
        int countTang =0,countGiam =0;
        for (int i = 1; i < n; i++) {
            if (a[i]>a[i-1]){
                countTang++;
            }
            if (a[i]<a[i-1]){
                countGiam++;
            }
            
            
        }
        if(countGiam==n-1||countTang==n-1){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }
    }

}
//Tuy nhiên cảm giác cách này vẫn có vẻ chưa hay lắm
//Vừa tham khao một cách khá hay:mình tạo 2 biến là kiemTra1 và kiemTra2 là 2 biến kiểm tra độ tăng và giảm, cứ gán cho cả hai là true 
//mình sẽ duyệt mảng để kiểm tra mảng có luôn tăng hay luôn giảm không, cái nào không thì gán false
//Output: 1 trong 2 biến là true thì trả về kết quả bài toán là true
