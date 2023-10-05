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
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean cont=false;
        do{
            try{
                int num;
                Scanner sc= new Scanner(System.in);
                System.out.println("Enter the number:");
                num=sc.nextInt();
                if(num<1)
                    throw new Exception();
            }catch(Exception e){
                System.out.println("The number is invalid");
                cont=true;
            }
        }while(cont);
    }
    
}
