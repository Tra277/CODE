/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Calculator{
    public int add(int a,int b){
        return a+b;
    }
     public int add(int a,int b,int c){
        return a+b+c;
    }
      public double add(double a,double b){
        return a+b;
    }
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(1,2));
        System.out.println(calculator.add(3.3,4.2));
        System.out.println(calculator.add(1,2,3));
    }
    
}
