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
    public String name;
    public String address;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s1 = new Student("Viet","Bac Ninh");
        Student s2 = new Student("Viet","Bac Ninh");
        System.out.println(s1 == s2);
        // Mặc dù s1 và s2 được khai báo cùng tên và địa chỉ
        // nhưng kết quả vần là false
    }
    
}
