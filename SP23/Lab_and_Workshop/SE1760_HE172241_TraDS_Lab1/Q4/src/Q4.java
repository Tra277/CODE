import java.util.Arrays;
import java.util.Scanner;
import java.util.IntSummaryStatistics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int a = sc.nextInt();
        int arr[]= new int [a];
        int maxNum = 0;
        int minNum = 0;
        for(int i = 0; i < a ; i++){
            System.out.format("Enter the elements #%d:", i);
            arr[i]= sc.nextInt();
            IntSummaryStatistics statistics = Arrays.stream(arr).summaryStatistics();
            minNum = statistics.getMin();
            maxNum = statistics.getMax();
        }
        System.out.println("OUTPUT");
        Arrays.sort(arr);
        for(int i=1; i<arr.length - 1 ;i++){
                System.out.format("%3d",arr[i]);      
        }
        System.out.println("");
    }
}