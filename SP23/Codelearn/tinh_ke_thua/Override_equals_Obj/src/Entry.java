/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Student{
    public int id;
    public String name;
    public String address;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Student) obj).id; //To change body of generated methods, choose Tools | Templates.
    }

    
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s1 = new Student(1000, "Viet", "Bac Ninh");
        Student s2 = new Student(1000 , "Viet", "Bac Ninh");
        System.out.println(s1.equals(s2));
    }
    
}
