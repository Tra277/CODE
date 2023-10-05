
import java.util.Scanner;

public class Tim_kiem_nhay {
    public static int Search(int x, int[] a){
        int start =0; int end = (int) Math.sqrt(a.length) ;
        while(start < a.length && a[end]<x){
            start = end;
            end = end + (int) Math.sqrt(a.length);
            if(end > a.length - 1) {
                end = a.length;
            }
        }
        for(int i = start; i<=end;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int x = sc.nextInt();
        System.out.println(Tim_kiem_nhay.Search(x,a));
        
    }
}
