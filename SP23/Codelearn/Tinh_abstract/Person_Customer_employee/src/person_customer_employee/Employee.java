/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person_customer_employee;

/**
 *
 * @author alexf
 */
public class Employee extends Person {
	private int salary;
	
	public Employee(String name, String address, int salary) {
		super(name, address);
		this.salary = salary;
	}

	@Override
	public void display() {
		System.out.println("Employee name: " + super.getName());
		System.out.println("Employee address: " + super.getAddress());
		System.out.println("Employee salary: " + salary);
	}	
}