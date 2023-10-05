/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
 class Student {
	private String name;
	private String address;
	private double gpa;

	public Student(String name, String address, double gpa) {
		this.name = name;
		this.address = address;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", address: " + address + ", GPA: " + gpa;
	}
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s = new Student("Kien", "Ha Noi", 6.6);
		System.out.println(s); // đây chính là s.toString();
    }
    
}
