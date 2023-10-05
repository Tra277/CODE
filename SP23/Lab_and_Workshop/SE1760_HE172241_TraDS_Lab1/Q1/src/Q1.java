/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
import java.util.Scanner;
public class Q1 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows:");
        int a = sc.nextInt();
        System.out.print("Enter the number of cols:");
        int b = sc.nextInt();
        int[][] matrix = new int[a][b];
        for (int i=0;i<a;i++)
            for (int j=0;j<b;j++){
                System.out.format("Enter matrix[%d][%d]:",i,j);
                matrix[i][j]= sc.nextInt();
            }
        System.out.println("OUTPUT");
        System.out.println("matrix inputted:");
        int sum=0;
        for (int i=0;i<a;i++){
            for (int j=0;j<b;j++){
               System.out.format("%3d", matrix[i][j]);
               sum +=matrix[i][j];
            }
            System.out.println();
        }    
           	System.out.format("sum = %3d\n", sum);
                
        
    }
    
}
