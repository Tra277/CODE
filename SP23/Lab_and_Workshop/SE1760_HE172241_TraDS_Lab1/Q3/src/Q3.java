import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements:");
        int n = sc.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element #"+i+":");
            a[i] = sc.nextInt();
        }
        int maxFrequency = 0;
        int maxValue = a[0];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count > maxFrequency) {
                maxFrequency = count;
                maxValue = a[i];
            }
        }
                System.out.println("OUTPUT");
        			System.out.format("The number with maximum frequency = %3d", maxValue);
    }
}