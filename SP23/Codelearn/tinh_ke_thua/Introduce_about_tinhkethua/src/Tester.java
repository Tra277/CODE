/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
    class Student extends Person{
        private double gpa;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    }
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s = new Student();
        s.setName("Thien");
        s.setAge(32);
        s.setGpa(7);
        System.out.println("Name: "+s.getName());
        System.out.println("Age: "+ s.getAge());
        System.out.println("Gpa: "+s.getGpa() );
    }
    
}
