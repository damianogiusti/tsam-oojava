package giusti.damiano.harbour.test;

import static org.junit.Assert.*;

import org.junit.Test;

import giusti.damiano.harbour.Aereo;

public class AereoTest {

	@Test
	public void test() {
		Aereo a = new Aereo();

		a.setnArmamentiAlpha(25);
		a.setnArmamentiBeta(10);

		double p = a.p();

		assertEquals(500, p, 0);
	}

}
