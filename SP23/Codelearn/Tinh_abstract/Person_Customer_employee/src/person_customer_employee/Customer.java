/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person_customer_employee;

public class Customer extends Person {
	private int balance;

	public Customer(String name, String address, int balance) {
		super(name, address);
		this.balance = balance;
	}

	@Override
	public void display() {
		System.out.println("Customer name: " + super.getName());
		System.out.println("Customer address: " + super.getAddress());
		System.out.println("Customer balance: " + balance);
	}
}