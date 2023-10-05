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
class Student{
    String name;
    int age;
    public void display(){
       
        System.out.println("Name: "+name);
        
        System.out.println("Age: "+age);
    }
    public void getInfo(){
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("Enter your age:");
        age = sc.nextInt();
    }
}
public class KhaiBaoClassAndObj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student doituong1 = new Student();
        doituong1.getInfo();
        doituong1.display();
    }
    
}
