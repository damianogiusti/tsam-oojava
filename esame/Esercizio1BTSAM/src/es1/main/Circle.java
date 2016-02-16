package es1.main;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Circle implements Shape {
	private double radius;
	
	public Circle() {
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double perimeter() {
		return Math.PI * 2 * radius;
	}
}
