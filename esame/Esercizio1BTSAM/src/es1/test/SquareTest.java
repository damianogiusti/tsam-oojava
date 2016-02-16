package es1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es1.main.Square;

/**
* NON MODIFICARE
*/
public class SquareTest {

	private static final double EPSILON = 0.01;
	
	@Test
	public void test() {
		Square r = new Square();
		r.setSide(5);
		assertEquals(25.0, r.area(), EPSILON);
		assertEquals(20.0, r.perimeter(), EPSILON);
	}

}
