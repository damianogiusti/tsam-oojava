package giusti.damiano.commercialista.test;

import static org.junit.Assert.*;

import org.junit.Test;

import giusti.damiano.commercialista.Imprenditore;

public class ImprenditoreTest {

	@Test
	public void test() {
		
		Imprenditore damiano = new Imprenditore();
		
		damiano.setNumeroAnnuoFatture(104);
		assertEquals(50400, damiano.totaleDaPagare());
		
		damiano.setNumeroAnnuoFatture(4);
		assertEquals(50000, damiano.totaleDaPagare());
		
	}

}
