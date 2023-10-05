/*package bai1_7;

import java.util.Scanner;

public class Bai1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[10000];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if(max<a[i]){
                max=a[i];
            }
            
        }
        
        for (int i = 0; i <= max; i++) {
            b[i]=0;
        }
        
        for (int i = 0; i < n; i++) {
            b[a[i]]++;
        }
        for (int i = 0; i <= max; i++) {
            if(b[i]>0){
                System.out.print(i+" - "+b[i]+"; ");
            };
        }        
    }

} */
//Tuy nhiên, cách giải tối ưu hơn là chúng ta sẽ sử dụng Hashmap
package bai1_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = a[i];
            if (counts.containsKey(value)) {
                counts.put(value, counts.get(value) + 1);
            } else {
                counts.put(value, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            System.out.print(entry.getKey() + " - " + entry.getValue() + "; ");
        }
    }
}