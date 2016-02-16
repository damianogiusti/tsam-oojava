package es1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import es1.main.Circle;

/**
* NON MODIFICARE
*/
public class CircleTest {

	private static final double EPSILON = 0.01;
	
	@Test
	public void test() {
		Circle t = new Circle();
		t.setRadius(10.5);
		
		// Nota: utilizza il valore di pi greco pari a:
		// Math.PI
		assertEquals(346.36, t.area(), EPSILON);
		assertEquals(65.97, t.perimeter(), EPSILON);
	}

}
