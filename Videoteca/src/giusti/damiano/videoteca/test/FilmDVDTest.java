package giusti.damiano.videoteca.test;

import static org.junit.Assert.*;

import org.junit.Test;

import giusti.damiano.videoteca.FilmDVD;

public class FilmDVDTest {

	@Test
	public void test() {
		
		FilmDVD fd = new FilmDVD();
		
		int costo = fd.costoNoleggio(4);
		
		assertEquals(700, costo);

	}

}
