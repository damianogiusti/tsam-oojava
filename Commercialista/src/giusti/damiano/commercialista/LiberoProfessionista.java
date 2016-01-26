package giusti.damiano.commercialista;

public class LiberoProfessionista extends Cliente {

	private int numeroAnnuoFatture;

	public LiberoProfessionista() {
		super();
	}

	public int totaleDaPagare() {
		return 50*100 + (numeroAnnuoFatture * 50);
	}

	public int getNumeroAnnuoFatture() {
		return numeroAnnuoFatture;
	}

	public void setNumeroAnnuoFatture(int numeroAnnuoFatture) {
		this.numeroAnnuoFatture = numeroAnnuoFatture;
	}
}
