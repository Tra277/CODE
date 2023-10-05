/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ishape_rectangle_circle;
public class Rectangle implements IShape {
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getPerimeter() {
		return (length + width) * 2;
	}
}