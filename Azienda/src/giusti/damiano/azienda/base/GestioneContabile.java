package giusti.damiano.azienda.base;

import java.util.ArrayList;
import java.util.List;

public class GestioneContabile {

	private Azienda azienda;

	public GestioneContabile(Azienda a) {
		azienda = a;
	}
	
	public Azienda getAzienda() {
		return azienda;
	}
	
	public void setAzienda(Azienda a) {
		azienda = a;
	}

	public static void main(String[] args) {
		List<Dipendente> dipendenti = new ArrayList<Dipendente>();
		for (int i = 0; i < 15; i++) {
			dipendenti.add(
					new Dipendente("Dipendente", "NR." + (i + 1), (i % 3) * 5, new Contratto("CD" + (i + 1), 100000)));
		}

		GestioneContabile gc = new GestioneContabile(new Azienda("MiaAzienda", dipendenti));

		for (Dipendente d : gc.getAzienda().getDipendenti()) {
			System.out.println(d.getNome() + " " + d.getCognome() + " con " + (double) d.stipendio() / 100 + "€");
		}
		
	}
}
