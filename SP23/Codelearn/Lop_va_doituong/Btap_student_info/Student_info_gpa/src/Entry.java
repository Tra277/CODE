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
import java.util.Locale;
 class Student{
    private String name;
    private int age;
    private String gender;
    double gpa;
    public Student() {
     
 }
    public Student(String name, int age, String gender, double gpa){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.gpa = gpa;
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("age: "+age);
        System.out.println("gender: "+gender);
        System.out.println("gpa: "+gpa);
    }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        
        Scanner sc= new Scanner(System.in);
        sc.useLocale(Locale.US); 
        Student hs1 = new Student("Tra", 19 ,"Nam",8.6);
        hs1.display();
    }
    
}
