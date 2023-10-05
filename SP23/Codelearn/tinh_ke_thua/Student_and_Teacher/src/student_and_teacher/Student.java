/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_and_teacher;

/**
 *
 * @author alexf
 */
public class Student extends Person {
    private double gpa;
    public Student(String name, int age, String address , double gpa) {
        super(name, age, address);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("GPA: "+gpa);
    }
    
    
}
