package main;

/**
* NON MODIFICARE
*/
public class Imprenditore  extends Cliente {
	
	private int numeroFatture;
	
	public double calcolaParcella() {
		return numeroFatture + 
			   getParcellaBase() + 
			   getParcellaBase() * 2 / 100.0f;
	}

	public int getNumeroFatture() {
		return numeroFatture;
	}

	public void setNumeroFatture(int numeroFatture) {
		this.numeroFatture = numeroFatture;
	}
}
