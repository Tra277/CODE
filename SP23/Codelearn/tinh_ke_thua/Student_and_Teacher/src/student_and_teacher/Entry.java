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
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s = new Student("Khanh", 23, "Ha Noi", 9.0);
		s.display();
		System.out.println();
		Teacher t = new Teacher("Tung", 34, "Ha Noi", 1700);
		t.display();
    }
    
}
