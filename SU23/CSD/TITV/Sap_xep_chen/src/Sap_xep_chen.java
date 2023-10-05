//Đây là tự mình nghĩ cho nên thuật toán có thể chưa được tối ưu và trình bày chưa được gọn gàng và code có thể hơi lòng vòng thừa thãi
//Mình sẽ tham khảo Bing trong bài Sap_xep_chen2
import java.util.Scanner;

public class Sap_xep_chen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
            
        }
        //Khởi tạo
        int currentValue = a[1];
        int position = 1;
        int index = 1;
        //Biến đổi
        while(index<n){
            while(position > 0 && currentValue<a[position-1]){
                //swap
                int temp = a[position];
                a[position]=a[position-1];
                a[position-1]=temp;
                position--;
                
            }
            index++;
            position =index;
            currentValue = a[position];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }

}
