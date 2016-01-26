package giusti.damiano.commercialista;

public class Fattura {

	private String cliente;
	private int importoInCentesimi;
	
	public Fattura() {
		
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getImportoInCentesimi() {
		return importoInCentesimi;
	}

	public void setImportoInCentesimi(int importoInCentesimi) {
		this.importoInCentesimi = importoInCentesimi;
	}
	
}
