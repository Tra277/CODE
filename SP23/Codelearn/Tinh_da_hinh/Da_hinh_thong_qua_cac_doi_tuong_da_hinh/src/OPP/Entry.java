/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPP;

/**
 *
 * @author alexf
 */
class Animal{
    public void sound(){
        System.out.println("some sound");
}
}
    class Dog extends Animal{
        @Override
        public void sound(){
            System.out.println("gau gau");
        }
    }
    class Cat extends Animal{
        @Override
        public void sound(){
            System.out.println("meo meo");
        }
    }
    class Duck extends Animal{
        @Override
        public void sound(){
            System.out.println("cac cac");
        }
    }

public class Entry {

    /**
     * @param args the command line arguments
     */
    public static  void main(String[] args) {
        // TODO code application logic here
        Animal animal = new Animal();
        animal.sound();
        animal = new Dog();
        animal.sound();
        animal = new Duck();
        animal.sound();
        animal = new Cat();
        animal.sound();
    }
    }

  
