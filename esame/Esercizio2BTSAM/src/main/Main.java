package main;

import java.util.Random;

/**
* NON MODIFICARE
*/
public class Main {
	
	  private static final char[] symbols;
	  private static final char[] buf = new char[4];
	  private static final Random random = new Random(354);
	  
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
		Commercialista azienda = new Commercialista();
		
		Cliente d1 = null;
		Cliente d2 = null;
			
		for(int i = 0; i < 10000000; ++i) {
			
			if (randI.nextInt() % 2 == 0) {
				Imprenditore m = new Imprenditore();
				m.setNumeroFatture(10);
				m.setParcellaBase(randI.nextInt(10));
				m.setCF(nextString());
				//
				azienda.addCliente(m);
				d1 = m;
				
			} else {
				Dipendente s = new Dipendente();
				s.setParcellaBase(randI.nextInt(10));
				s.setCF(nextString());
				
				azienda.addCliente(s);
				d2 = s;
			}
		}
		
		System.out.println("totale parcella: " + azienda.totaleParcelle());
		System.out.println("clienti duplicati: " + azienda.clientiDuplicati());
		System.out.println("duplicati cliente 1: " + azienda.numeroRipetizioni(d1));
		System.out.println("duplicati cliente 2: " + azienda.numeroRipetizioni(d2));
	}

}
