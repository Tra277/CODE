/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Person{
    private final int id;
    private final String name;
    private final int age;
    private final String address;
    public Person(int id, String name , int age, String address){
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p1 = new Person(172241,"Tra",20,"ha noi");
        System.out.println("Name: "+p1.getName());
        System.out.println("Id: "+p1.getId());
        System.out.println("Age: "+p1.getAge());
        System.out.println("Address: "+p1.getAddress());
    }
    
}
