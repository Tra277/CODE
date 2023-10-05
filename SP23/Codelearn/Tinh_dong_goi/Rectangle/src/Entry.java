/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexf
 */
class Rectangle {
	private double length;
	private double width;

	public Rectangle() {

	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getArea() {
		return length * width;
	}

	public double getPerimeter() {
		return (length + width) * 2;
	}
}
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle r = new Rectangle(4, 5);
		System.out.println("Area: " + r.getArea());
		System.out.println("Perimeter: " + r.getPerimeter());
		r.setLength(2);
		r.setWidth(3);
		System.out.println("Area: " + r.getArea());
		System.out.println("Perimeter: " + r.getPerimeter());
    }
    
}
