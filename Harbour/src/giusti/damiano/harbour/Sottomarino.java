package giusti.damiano.harbour;

public class Sottomarino extends Invasore  {
	
	private int numArmamenti;
	private float stazza;
	
	public int getNumArmamenti() {
		return numArmamenti;
	}
	public void setNumArmamenti(int numArmamenti) {
		this.numArmamenti = numArmamenti;
	}
	public float getStazza() {
		return stazza;
	}
	public void setStazza(float stazza) {
		this.stazza = stazza;
	}
	
	public double p() {
		return numArmamenti * stazza;
	}
	
	public double distruggiMq() {
		return p() * 1.5;
	}

}
