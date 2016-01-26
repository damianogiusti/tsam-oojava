package giusti.damiano.commercialista;

public class Commercialista {
	
	private Cliente[] clienti;
	
	public Commercialista() {
		
	}

	public Cliente[] getClienti() {
		return clienti;
	}

	public void setClienti(Cliente[] clienti) {
		this.clienti = clienti;
	}
	
	public int incassoTotale() {
		int somma = 0;
		for (Cliente c : clienti)
			somma += c.totaleDaPagare();
		return somma;
	}

	public static void main(String[] args) {
		
	}
	
}
