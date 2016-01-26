package giusti.damiano.commercialista.test;

import static org.junit.Assert.*;

import org.junit.Test;

import giusti.damiano.commercialista.Fattura;
import giusti.damiano.commercialista.LiberoProfessionista;

public class LiberoProfessionistaTest {

	@Test
	public void test() {
		LiberoProfessionista damiano = new LiberoProfessionista();
		
		damiano.setNome("Damiano");
		damiano.setCognome("Giusti");
		damiano.setNumeroAnnuoFatture(4);
		
		assertEquals(5200, damiano.totaleDaPagare());
	}

}
