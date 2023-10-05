
import java.util.Scanner;
import java.util.Stack;
import jdk.nashorn.internal.objects.NativeArray;

public class Bai2_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stackString = new Stack<String>();
        String s = sc.nextLine();
        int count =1;
        //Lấy phần tử vào
        for (int i = s.length()-2; i >=0; i--) {
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }else{
                stackString.push(count+"");                
                stackString.push(s.charAt(i+1)+"");

                count=1;
            
            }
            
        }

                
        //fix bug
        int j=1;
        int cntBug=1;
        while(s.charAt(j)==s.charAt(j-1)){
            cntBug++;
            j++;
        }
        stackString.push(count+"");                
        stackString.push(s.charAt(j-1)+"");        
        
        
        
        //Lấy phần tử ra
        int n = stackString.size();
        for (int i = 0; i < n; i++) {
            System.out.print(stackString.pop());
            
        }
    }

}
