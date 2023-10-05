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
    private String name;
    private  int age;
    public Student(){
        
    }
    public void getInformation(){
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();
    }
    public void display(){
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
    }
    
}
public class So_do_lop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s1 = new Student();
        s1.getInformation();
        s1.display();
        
    }
    
}
