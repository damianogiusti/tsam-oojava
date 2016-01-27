package giusti.damiano.harbour.test;

import static org.junit.Assert.*;

import org.junit.Test;

import giusti.damiano.harbour.Sottomarino;

public class SottomarinoTest {

	@Test
	public void test() {
		Sottomarino s = new Sottomarino();
		
		s.setNumArmamenti(15);
		s.setStazza(1500);
		
		double p = s.p();
		
		assertEquals(22500, p, 0);
		
	}

}
