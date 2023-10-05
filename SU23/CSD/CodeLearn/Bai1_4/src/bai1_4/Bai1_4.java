package bai1_4;

import java.util.Scanner;

public class Bai1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        int k = sc.nextInt();int x=sc.nextInt();
        //Phải dùng vòng for ngược vì dùng xuôi thì sai vì các giá trị cũ bị mất đi
        //VD:a[4]=a[3] sau đó gán a[5]=a[4] là sai vì bây giờ a[4] giữ giá trị của a[3] chứ không phải giá trị a[4] ban đầu nữa
        for (int i = n-1; i >= k; i--) {
            a[i+1]=a[i];
        }
        a[k]=x;
        for (int i : a) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

}