/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return 3.14 * radius * radius;
	}

	public double getCircumference() {
		return 3.14 * 2 * radius;
	}
}
public class HinhTron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circle c = new Circle(7);
		System.out.println(c.getArea());
		System.out.println(c.getCircumference());
    }
    
}
