package it.damianogiusti.orarioits.test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import it.damianogiusti.orarioits.Giornata;

public class GiornataTest {

	@Test
	public void test() {
		Giornata g;
		try {
			g = new Giornata("1-feb-16 lun");
			
			g.addOrari("14,00");
			g.addOrari("18,00");
			g.addMateria("Materia di prova");
			g.addDocente("Damiano");
			
			assertEquals("14:00 - 18:00", g.getOrari()[1]);
			assertEquals("Materia di prova", g.getMaterie()[1]);
			assertEquals("Damiano", g.getDocenti()[1]);
			
		} catch (ParseException e) {
			e.printStackTrace(System.err);
		}
	}

}
