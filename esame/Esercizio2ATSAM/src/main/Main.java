package main;

import java.util.Random;

/**
* NON MODIFICARE
*/
public class Main {
	
	  private static final char[] symbols;
	  private static final char[] buf = new char[4];
	  private static final Random random = new Random();
	  
	  static {
	    StringBuilder tmp = new StringBuilder();
	    for (char ch = '0'; ch <= '9'; ++ch)
	      tmp.append(ch);
	    for (char ch = 'a'; ch <= 'z'; ++ch)
	      tmp.append(ch);
	    symbols = tmp.toString().toCharArray();
	  }   

	  public static String nextString() {
	    for (int idx = 0; idx < buf.length; ++idx) 
	      buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	  }
	
	
	
	public static void main(String[] args) {

		
		Random randI = new Random(101);
		Azienda azienda = new Azienda();
		
		Dipendente d1 = null;
		Dipendente d2 = null;
			
		for(int i = 0; i < 10000000; ++i) {
			
			if (randI.nextInt() % 2 == 0) {
				Manager m = new Manager();
				m.setAnzianita(1);
				m.setBonus(10);
				m.setPagaBase(randI.nextInt(10));
				m.setCF(nextString());
				//
				azienda.addDipendente(m);
				d1 = m;
				
			} else {
				Sviluppatore s = new Sviluppatore();
				s.setAnzianita(1);
				s.setPagaBase(randI.nextInt(10));
				s.setCF(nextString());
				d2 = s;
				
				azienda.addDipendente(s);
			}
		}
		
		System.out.println("totale stipendi: " + azienda.totaleStipendi());
		System.out.println("dipendenti duplicati: " + azienda.dipendentiDuplicati());
		System.out.println("duplicati dipendente d1: " + azienda.numeroRipetizioni(d1));
		System.out.println("duplicati dipendente d2: " + azienda.numeroRipetizioni(d2));
	}

}
