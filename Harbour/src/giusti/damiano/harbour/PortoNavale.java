package giusti.damiano.harbour;

public class PortoNavale {
	
	private String nome;
	private int numeroImbarcazioni;
	private double dimensioneMq;
	private int numAttacchi;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroImbarcazioni() {
		return numeroImbarcazioni;
	}
	public void setNumeroImbarcazioni(int numeroImbarcazioni) {
		this.numeroImbarcazioni = numeroImbarcazioni;
	}
	public double getDimensioneMq() {
		return dimensioneMq;
	}
	public void setDimensioneMq(double dimensioneMq) {
		this.dimensioneMq = dimensioneMq;
	}
	public int getNumAttacchi() {
		return numAttacchi;
	}
	public void setNumAttacchi(int numAttacchi) {
		this.numAttacchi = numAttacchi;
	}
	public void arrecaDanno(double danno) { 
		dimensioneMq -= danno;
	}
	public void incrementaNumAttacchi() {
		numAttacchi++;
	}

}
