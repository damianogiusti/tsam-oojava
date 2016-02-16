package es1.main;

/**
 * ************* *
 * DA COMPLETARE *
 * ************* *
 */
public class Statistics {
	
	public double area;
	public double perimeter;
	
	public Statistics() {
		this.area = 0;
		this.perimeter = 0;
	}
	
	public Statistics(double perimeter, double area) {
		this.area = area;
		this.perimeter = perimeter;
	}
	
	public void add(Statistics s) {
		this.area += s.getArea();
		this.perimeter += s.getPerimeter();
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	
}
