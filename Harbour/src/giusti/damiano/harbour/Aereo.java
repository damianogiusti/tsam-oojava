package giusti.damiano.harbour;

public class Aereo extends Invasore {
	
	private int nArmamentiAlpha;
	private int nArmamentiBeta;
	
	public int getnArmamentiAlpha() {
		return nArmamentiAlpha;
	}
	public void setnArmamentiAlpha(int nArmamentiAlpha) {
		this.nArmamentiAlpha = nArmamentiAlpha;
	}
	public int getnArmamentiBeta() {
		return nArmamentiBeta;
	}
	public void setnArmamentiBeta(int nArmamentiBeta) {
		this.nArmamentiBeta = nArmamentiBeta;
	}
	
	public double p() {
		return (nArmamentiAlpha * 10) + (nArmamentiBeta * 25);
	}
	
	public double distruggiMq() {
		return p() * 1.5;
	}

}
