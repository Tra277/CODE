/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Animal{
    public void sound(){
        System.out.println("some sound");
    }
}
class Cat extends Animal{
    @Override
    public void sound(){
        System.out.println("meo meo");
    }
}
class Dog extends Animal{
     @Override
     public void sound(){
         System.out.println("gau gau");
     }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Up-casting
        Animal animal1 = new Cat();
        animal1.sound();
        //Up-casting
        Animal animal2 = new Dog();
        animal2.sound();
    }
    
}
