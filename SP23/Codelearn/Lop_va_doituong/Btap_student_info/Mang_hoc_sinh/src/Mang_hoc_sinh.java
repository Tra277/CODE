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
	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}
public class Mang_hoc_sinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student[] s = new Student[3];
        s[0] = new Student("Tra",24);
        s[1] = new Student("Huyen",24);
        s[2] = new Student("Vu",24);
        for (int i=0;i<3;i++){
            s[i].display();
        }
    }
    
}
