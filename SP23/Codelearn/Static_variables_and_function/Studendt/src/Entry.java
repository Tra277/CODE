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
    private String name;
    private char gender;
    public Student(){
            name ="unknown";
            gender='u';
}
    public Student(String name){
        this.name = name;
        gender='u';
    }
    public Student(char gender){
        this.gender = gender;
        name="unknown";
    }
    public Student(String name , char gender){
        this.name=name;
        this.gender = gender;
    }
    public void display(){
        System.out.println("Name: "+name);
        if (gender == 'u') System.out.println("Gender: Unknown");
        if (gender == 'm') System.out.println("Gender: Male");
        if (gender == 'f') System.out.println("Gender: Female");
    }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                Student s1 = new Student();
		s1.display();
		Student s2 = new Student("Quang");
		s2.display();
		Student s3 = new Student('m');
		s3.display();
		Student s4 = new Student("Thu", 'f');
		s4.display();
    }
}
