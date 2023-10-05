/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;
import java.lang.Comparable;
/**
 *
 * @author ACER
 */
public class Employee implements Comparable {
    private String code;
    private String name;
    private int salary;

    public Employee() {
    }
    
    public Employee (String c, String n, int s) {
        this.code = c;
        this.name = n;
        this.salary = s;
    }
    
    public void print() {
        System.out.println("Code = " + code + " Name = " + name + " Salary = " + salary);;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public int compareTo(Object emp) {
        return this.getCode().compareTo(((Employee)emp).getCode());
    }

}
