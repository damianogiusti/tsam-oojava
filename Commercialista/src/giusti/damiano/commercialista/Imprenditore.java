package giusti.damiano.commercialista;

public class Imprenditore extends Cliente {

	private String partitaIva;
	private String ragioneSociale;
	private int numeroAnnuoFatture;

	public Imprenditore() {

	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getNumeroAnnuoFatture() {
		return numeroAnnuoFatture;
	}

	public void setNumeroAnnuoFatture(int numeroAnnuoFatture) {
		this.numeroAnnuoFatture = numeroAnnuoFatture;
	}

	public int totaleDaPagare() {
		return ((numeroAnnuoFatture < 101) ? (500 * 100) : ((500 * 100) + ((numeroAnnuoFatture - 100) * 100)));
	}

}
