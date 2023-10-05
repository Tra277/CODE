import java.util.Scanner;

public class Bai1_6 {
    public static boolean isPrime(int k){
        int count=0;
        for(int i=1;i<=k;i++){
            if(k%i==0){
                count++;
            }
        }
        return (count==2)?true:false;
        
    }
    //Ngoài ra còn cách khác có hiệu năng tốt như là: Nếu n không có ước trong 
    //khoảng 2 đến phần nguyên căn bậc 2 của n thì là số nguyên tố
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if(isPrime(a[i])==true){
                System.out.print(a[i]);
                System.out.print(" ");
            }
        }

}
}
