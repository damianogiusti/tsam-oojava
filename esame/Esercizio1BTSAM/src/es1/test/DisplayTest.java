package es1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es1.main.Display;
import es1.main.Circle;
import es1.main.Square;
import es1.main.Shape;

/**
* NON MODIFICARE
*/
public class DisplayTest {

	@Test
	public void testTotalArea() {
		Square r = new Square();
		r.setSide(9.5);
		
		Circle t = new Circle();
		t.setRadius(14);
		
		Display d = new Display();
		d.setShapes(new Shape[]{r, t});
		
		assertEquals(706.0, d.totalArea(), 0.01);
	}

	@Test
	public void testTotalPerimeter() {
		Square r = new Square();
		r.setSide(58);
		
		Circle t = new Circle();
		t.setRadius(15.3);
		
		Display d = new Display();
		d.setShapes(new Shape[]{r, t});
		
		assertEquals(328.13, d.totalPerimeter(), 0.01);
	}

}
