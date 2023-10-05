/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findprime;

/**
 *
 * @author alexf
 */
import java.util.Scanner;

public class FindPrime {
    public static int Isprime(int a){
        int count = 0;
        for (int i =1 ; i<a ;i++){
            if(a%i==0) count++;
        }
        return count;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = sc.nextInt();
        int[] a= new int[n];
        for (int i=0 ; i<n ;i++) a[i]= sc.nextInt();
        System.out.print("This is list of prime integer: ");
        for ( int x :a) if(Isprime(x)==1 && x>1 && x<20) System.out.print(x+" ");
        
    }
    
}
