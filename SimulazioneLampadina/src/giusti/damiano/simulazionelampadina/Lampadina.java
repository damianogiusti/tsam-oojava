package giusti.damiano.simulazionelampadina;

class LampadinaBruciataException extends Exception {
}

public class Lampadina {

	private int cicliMax;
	private int contaCicli;
	private boolean stato;

	public Lampadina() {
		this.cicliMax = 0;
		this.contaCicli = 0;
	}

	public Lampadina(int cicliMax) {
		this.cicliMax = cicliMax;
		this.contaCicli = 0;
	}

	public void switchOn() throws LampadinaBruciataException {
		stato = true;
		if (++contaCicli == cicliMax)
			throw new LampadinaBruciataException();
	}

	public void switchOff() {
		stato = false;
	}

	public static void main(String[] args) {
		Lampadina lampadina = new Lampadina(50000);

		int cicliProva = 49999;

		try {

			for (int i = 0; i < cicliProva; i++) {
				lampadina.switchOn();
				lampadina.switchOff();
			}
			System.out.println("Eseguiti i cicli di prova");

		} catch (LampadinaBruciataException e) {
			e.printStackTrace();
		} finally {
			lampadina.switchOff();
		}

	}

}
