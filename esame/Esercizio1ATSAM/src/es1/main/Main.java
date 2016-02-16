package es1.main;

import java.util.Random;

/**
* NON MODIFICARE
*/
public class Main {
	
	private static void testA(){
		Statistics statRectangle = new Statistics(0, 0);
		Statistics statEquilateralTriangle = new Statistics(0, 0);
		
		Random randI = new Random(101);
		Random randD = new Random(101);
			
		for(int i = 0; i < 1000; ++i) {
			
			if (randI.nextInt() % 2 == 0) {
				Rectangle r = new Rectangle();
				r.setHeight(randD.nextDouble() * 10.0);
				r.setWidth(randD.nextDouble()* 10.0);
				statRectangle.add(new Statistics(r.perimeter(), r.area()));
			} else {
				EquilateralTriangle e= new EquilateralTriangle();
				e.setBase(randD.nextDouble() * 10.0);
				e.setHeight(randD.nextDouble() * 10.0);
				statEquilateralTriangle.add(new Statistics(e.perimeter(), e.area()));
			}
		}
		
		System.out.println("Rectangle Perimeter: " + Math.round(statRectangle.perimeter));
		System.out.println("Rectangle Area: " + Math.round(statRectangle.area));
		System.out.println("EquilateralTriangle Perimeter: " + Math.round(statEquilateralTriangle.perimeter));
		System.out.println("EquilateralTriangle Area: " + Math.round(statEquilateralTriangle.area));
	}
	
	private static void testB(){	
		Random randI = new Random(301);
		Random randD = new Random(301);
			
		int counter = 1000; 
		
		Shape[] shapes = new Shape[counter];
		
		Display display = new Display();
		
		for(int i = 0; i < counter; ++i) {
			
			if (randI.nextInt() % 2 == 0) {
				Rectangle r = new Rectangle();
				r.setHeight(randD.nextDouble() * 10.0);
				r.setWidth(randD.nextDouble()* 10.0);
				shapes[i] = r;
			} else {
				EquilateralTriangle e= new EquilateralTriangle();
				e.setBase(randD.nextDouble() * 10.0);
				e.setHeight(randD.nextDouble() * 10.0);
				shapes[i] = e;
			}
		}
		
		
		display.setShapes(shapes);
		
		System.out.println("Total perimeter: " + Math.round(display.totalPerimeter()));
		System.out.println("Total area: " + Math.round(display.totalArea()));
		
	}
	
	public static void main(String[] args) {
		testA();
		testB();
	}

}
