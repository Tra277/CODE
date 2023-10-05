/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
import java.util.Scanner;
class Rectangle {
    double length;
    double width;
    public void getInfo(){
        Scanner sc =new Scanner(System.in);
        width= sc.nextDouble();
        length= sc.nextDouble();
        
    }
    public double getArea(){
        return (length*width);
    }
    public double getPerimeter(){
        return (length+width)*2;
    }
    public void display(){
        System.out.println("Area: "+getArea());
        System.out.println("P: "+getPerimeter());
}
}
public class P_and_S_of_HCN {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle hcn1 = new Rectangle();
        hcn1.getInfo();
        hcn1.display();
    }
    
}
