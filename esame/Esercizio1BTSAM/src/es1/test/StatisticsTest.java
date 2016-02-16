package es1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es1.main.Statistics;

/**
* NON MODIFICARE
*/
public class StatisticsTest {

	@Test
	public void test() {
		double perimeter1 = 5;
		double area1 = 10;
		Statistics st1 = new Statistics(perimeter1, area1);

		double perimeter2 = 3;
		double area2 = 4;
	
		st1.add(new Statistics(perimeter2, area2));
		
		assertEquals(14, st1.getArea(), 0.01);
		assertEquals(8, st1.getPerimeter(), 0.01);
	
	}

}
