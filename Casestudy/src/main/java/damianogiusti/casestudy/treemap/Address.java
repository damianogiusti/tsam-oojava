package damianogiusti.casestudy.treemap;

public class Address implements Comparable<Address> {
	
	private String tipoVia;
	private String via;
	private String nomeVia;
	
	public Address() {
		tipoVia = "";
		via = "";
		nomeVia = "";
	}
	
	public Address(String tipoVia, String via, String nomeVia) {
		this.tipoVia = tipoVia;
		this.via = via;
		this.nomeVia = nomeVia;
	}
	
	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNomeVia() {
		return nomeVia;
	}

	public void setNomeVia(String nomeVia) {
		this.nomeVia = nomeVia;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Address))
			return false;

		return this.toString().equals(obj.toString());
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public int compareTo(Address o) {	
		return this.toString().compareTo(o.toString());
	}
	
	@Override
	public String toString() {
		return tipoVia + " " + via + " " + nomeVia;
	}
	
	

}
