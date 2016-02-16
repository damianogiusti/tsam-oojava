package main;

/**
* NON MODIFICARE
*/
public class Manager  extends Dipendente {
	
	private int bonus;
	
	public double calcolaStipendio() {
		return bonus + 
			   getPagaBase() + 
			   getPagaBase() * getAnzianita() * 2 / 100.0f;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
}
