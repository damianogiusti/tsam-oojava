package tsam.damianogiusti;

public class Contratto {
	private String nome;
	private int stipendioBaseAnnuo;
	
	public Contratto(String n, int s) {
		nome = n;
		stipendioBaseAnnuo = s;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStipendioBaseAnnuo() {
		return stipendioBaseAnnuo;
	}

	public void setStipendioBaseAnnuo(int stipendioBaseAnnuo) {
		this.stipendioBaseAnnuo = stipendioBaseAnnuo;
	}
	
	
}
