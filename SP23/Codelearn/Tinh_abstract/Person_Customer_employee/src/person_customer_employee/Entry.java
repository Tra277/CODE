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
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person person1 = new Employee("Trung", "HN", 3300);
		Person person2 = new Customer("Linh", "BN", 10400);
		person1.display();
		person2.display();
    }
    
}
