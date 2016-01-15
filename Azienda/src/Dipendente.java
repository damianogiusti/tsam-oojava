
public class Dipendente {
	private String nome;
	private String cognome;
	private int anzianita;
	private Contratto contratto;

	public Dipendente(String n, String c, int a, Contratto ctr) {
		nome = n;
		cognome = c;
		anzianita = a;
		contratto = ctr;
	}

	public double stipendio() {
		return contratto.getStipendioBaseAnnuo() + ((contratto.getStipendioBaseAnnuo() * 0.005) * anzianita);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnzianita() {
		return anzianita;
	}

	public void setAnzianita(int anzianita) {
		this.anzianita = anzianita;
	}

	public Contratto getContratto() {
		return contratto;
	}

	public void setContratto(Contratto contratto) {
		this.contratto = contratto;
	}
	
	
}
