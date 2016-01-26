package giusti.damiano.videoteca;

public class Film {
	
	private String titolo;
	private String nomeRegista;
	private int annoProduzione;
	private String[] attori;
	
	public Film() {
		
	}
	
	public int costoNoleggio(int numGiorni) {
		return 0;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNomeRegista() {
		return nomeRegista;
	}

	public void setNomeRegista(String nomeRegista) {
		this.nomeRegista = nomeRegista;
	}

	public int getAnnoProduzione() {
		return annoProduzione;
	}

	public void setAnnoProduzione(int annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	public String[] getAttori() {
		return attori;
	}

	public void setAttori(String[] attori) {
		this.attori = attori;
	}
	
}
