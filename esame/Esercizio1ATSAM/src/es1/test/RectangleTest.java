package es1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es1.main.Rectangle;

/**
* NON MODIFICARE
*/
public class RectangleTest {

	private static final double EPSILON = 0.01;
	
	@Test
	public void test() {
		Rectangle r = new Rectangle();
		r.setWidth(10);
		r.setHeight(5);
		assertEquals(50.0, r.area(), EPSILON);
		assertEquals(30.0, r.perimeter(), EPSILON);
	}

}
