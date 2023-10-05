
import java.util.Scanner;


public class Tim_kiem_nhi_phan {
    public static int Search(int x, int[] a){
        
        int indexLeft =0,indexRight = a.length -1;
        
        while(indexLeft<=indexRight){
            int midIndex = (indexLeft + indexRight)/2;
            if(a[midIndex]==x){
                return midIndex;
            }; 
            if(a[midIndex]<x){
                 indexLeft = midIndex +1;

            }else{
                indexRight = midIndex - 1;
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
        System.out.println(Tim_kiem_nhi_phan.Search(x,a));
        
    }

}
