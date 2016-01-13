import java.util.ArrayList;
import java.util.List;

public class Azienda {
	
	String ragioneSociale;
	List<Dipendente> dipendenti;
	
	public Azienda(String r) {
		ragioneSociale = r;
		dipendenti = new ArrayList<Dipendente>();
	}
	
	public Azienda(String r, List<Dipendente> d) {
		ragioneSociale = r;
		dipendenti = d;
	}

	public double sommaStipendi() {
		double somma = 0;
		for (Dipendente d : dipendenti) {
			somma += d.stipendio();
		}
		return somma;
	}
	
	public List<Dipendente> dipendentiMaxStipendio() {
		double max = 0;
		for (Dipendente d : dipendenti) {
			if (d.stipendio() > max)
				max = d.stipendio();
		}
		
		List<Dipendente> elenco = new ArrayList<Dipendente>();
		for (Dipendente d : dipendenti)
			if (d.stipendio() == max)
				elenco.add(d);
		
		return elenco;
	}
}
