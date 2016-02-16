package es1.main;

import java.util.Random;

/**
* NON MODIFICARE
*/
public class Main {
	
	private static void testA(){
		Statistics statSquare = new Statistics(0, 0);
		Statistics statCircle = new Statistics(0, 0);
		
		Random randI = new Random(111);
		Random randD = new Random(111);
			
		for(int i = 0; i < 1000; ++i) {
			
			if (randI.nextInt() % 2 == 0) {
				Square r = new Square();
				r.setSide(randD.nextDouble() * 10.0);
				statSquare.add(new Statistics(r.perimeter(), r.area()));
			} else {
				Circle e= new Circle();
				e.setRadius(randD.nextDouble() * 10.0);
				statCircle.add(new Statistics(e.perimeter(), e.area()));
			}
		}
		
		System.out.println("Square Perimeter: " + Math.round(statSquare.perimeter));
		System.out.println("Square Area: " + Math.round(statSquare.area));
		System.out.println("Circle Perimeter: " + Math.round(statCircle.perimeter));
		System.out.println("Circle Area: " + Math.round(statCircle.area));
	}
	
	private static void testB(){	
		Random randI = new Random(311);
		Random randD = new Random(311);
			
		int counter = 1000; 
		
		Shape[] shapes = new Shape[counter];
		
		Display display = new Display();
		
		for(int i = 0; i < counter; ++i) {
			
			if (randI.nextInt() % 2 == 0) {
				Square r = new Square();
				r.setSide(randD.nextDouble() * 10.0);
				shapes[i] = r;
			} else {
				Circle e= new Circle();
				e.setRadius(randD.nextDouble() * 10.0);
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
