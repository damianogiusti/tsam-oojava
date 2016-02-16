package es1.main;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Display {
	
	Shape[] shapes;
	
	public Display() {
	
	}
	
	public Shape[] getShapes() {
		return shapes;
	}
	
	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
	}
	
	public double totalArea() {
		double sum = 0;
		for (Shape s : shapes)
			sum += s.area();
		return sum;
	}
	
	public double totalPerimeter() {
		double sum = 0;
		for (Shape s : shapes)
			sum += s.perimeter();
		return sum;
	}
	
}
