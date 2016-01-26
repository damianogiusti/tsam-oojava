package giusti.damiano.videoteca.test;

import static org.junit.Assert.*;

import org.junit.Test;

import giusti.damiano.videoteca.FilmCassetta;

public class FilmCassettaTest {

	@Test
	public void test() {
		
		FilmCassetta fc = new FilmCassetta();
		
		int costo = fc.costoNoleggio(3);
		
		assertEquals(500, costo);
	}

}
