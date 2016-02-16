package es1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es1.main.EquilateralTriangle;

/**
* NON MODIFICARE
*/
public class EquilateralTriangleTest {

	private static final double EPSILON = 0.01;
	
	@Test
	public void test() {
		EquilateralTriangle t = new EquilateralTriangle();
		t.setHeight(10.5);
		t.setBase(5);
		assertEquals(26.25, t.area(), EPSILON);
		assertEquals(15.0, t.perimeter(), EPSILON);
	}

}
