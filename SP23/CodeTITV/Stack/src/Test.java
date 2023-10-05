
import static java.lang.Math.E;
import java.util.Scanner;
import java.util.Stack;
import sun.net.www.content.audio.x_aiff;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Stack<String> stackChuoi = new Stack<String>();
        // vi du dao nguoc chuoi
        System.out.println("Nhap vao chuoi: ");
        String s = sc.nextLine();
        for(int i=0; i<s.length();i++){
            stackChuoi.push(s.charAt(i)+"");
        }
        System.out.println("Reverse:");
        for(int i=0; i<s.length();i++){
            System.out.print(stackChuoi.pop());
        }
          // vi du chuyen tu he thap phan =>> nhi phan
          Stack<String> stackSoDu = new Stack<>();
          System.out.println("Nhap 1 so nguyen duong:");
          int x = sc.nextInt();
          while(x>0){
              int soDu = x%2;
              stackSoDu.push(soDu+"");
              x = x/2;
          }
          for (int i=0; i<stackSoDu.size();i++){
              System.out.print(stackSoDu.peek());
          }
    }
  
    
}
