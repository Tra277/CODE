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
public class Teacher extends Person{
   private int salary; 

    public Teacher(String name, int age, String address , int salary) {
        super(name, age, address);
        this.salary=salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Salary: "+salary);
    }
    
}
