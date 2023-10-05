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
class Dog extends Animal{
    public void sound(){
        System.out.println("gau gau");
    }
    public void play(){
        System.out.println("The dog is playing");
    }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Up-casting
        Animal cho = new Dog();
        cho.sound();
        //Down-casting
        ((Dog)cho).play();
        
    }
    
}
