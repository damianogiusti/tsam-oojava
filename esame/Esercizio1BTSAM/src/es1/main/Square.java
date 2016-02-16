package es1.main;

/**
 * ************* * DA COMPLETARE * ************* *
 */
public class Square implements Shape {

	private double side;

	public Square() {

	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double area() {
		return side * side;
	}

	@Override
	public double perimeter() {
		return side * 4;
	}

}
