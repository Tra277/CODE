package bubblesort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            //Mình hay bị nhầm là j < n - i ==> phải là j < n-i-1;
            for (int j = 0; j < n-i-1; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
    }

}
