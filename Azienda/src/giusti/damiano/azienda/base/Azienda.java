package giusti.damiano.azienda.base;

import java.util.ArrayList;
import java.util.List;

public class Azienda {
	
	private String ragioneSociale;
	private String piva;
	private List<Dipendente> dipendenti;
	
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

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}
	
}
