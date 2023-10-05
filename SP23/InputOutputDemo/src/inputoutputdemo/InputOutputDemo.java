/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputoutputdemo;
import java.util.Scanner;

public class InputOutputDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
          
           int i;
           Scanner sc = new Scanner(System.in);
           System.out.print("Enter the number of elements: ");
         int n= sc.nextInt();
         int[] a = new int[n];
         for( i=0;i<n;i++){
             System.out.print("Enter the "+(i+1)+"/" +n+" elenment:");
             a[i] = sc.nextInt();
         }
         System.out.println("Entered value: ");
         for ( int x : a) System.out.format("%5d", x);
         int S=0;
         for (int x: a) S+=x;
         System.out.println("\nSum:= "+S);
    }
    
}
