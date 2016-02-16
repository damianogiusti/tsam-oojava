package es1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es1.main.Display;
import es1.main.EquilateralTriangle;
import es1.main.Rectangle;
import es1.main.Shape;

/**
* NON MODIFICARE
*/
public class DisplayTest {

	@Test
	public void testTotalArea() {
		Rectangle r = new Rectangle();
		r.setWidth(7.2);
		r.setHeight(9.5);
		
		EquilateralTriangle t = new EquilateralTriangle();
		t.setHeight(14);
		t.setBase(5.2);
		
		Display d = new Display();
		d.setShapes(new Shape[]{r, t});
		
		assertEquals(104.8, d.totalArea(), 0.01);
	}

	@Test
	public void testTotalPerimeter() {
		Rectangle r = new Rectangle();
		r.setWidth(112.34);
		r.setHeight(58);
		
		EquilateralTriangle t = new EquilateralTriangle();
		t.setHeight(15.3);
		t.setBase(5.5);
		
		Display d = new Display();
		d.setShapes(new Shape[]{r, t});
		
		assertEquals(357.18, d.totalPerimeter(), 0.01);
	}

}
