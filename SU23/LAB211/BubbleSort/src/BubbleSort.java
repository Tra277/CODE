
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    private static Scanner sc = new Scanner(System.in);
    private static void BubbleSort(int[] a ){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    private static void ShowArray(int [] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int lengthOfArray;
        Random rd = new Random();
        System.out.println("Enter numbers of Integer:");
        lengthOfArray = Inputvalidation.getArrayLength();
        
        
        int[] a = new int[lengthOfArray];
        for (int i = 0; i < a.length; i++) {
            a[i]= rd.nextInt(lengthOfArray);
        }
        
        System.out.println("Unsorted Array:");
        ShowArray(a);
        
        BubbleSort(a);
        
        System.out.println("\nSorted Array:");
        ShowArray(a);
    }

}
