package giusti.damiano.simulazionelampadina;

class LampadinaBruciataException extends Exception {

	@Override
	public String getMessage() {
		return "Lampadina bruciata :C";
	}

}

public class Lampadina {

	private int cicliMax;
	private int contaCicli;

	public Lampadina() {
		this.cicliMax = 0;
		this.contaCicli = 0;
	}

	public Lampadina(int cicliMax) {
		this.cicliMax = cicliMax;
		this.contaCicli = 0;
	}

	public String switchOn() throws LampadinaBruciataException {
		if (++contaCicli == cicliMax)
			throw new LampadinaBruciataException();

		return "Lampadina accesa";
	}

	public String switchOff() {
		return "Lampadina spenta";
	}

	public static void main(String[] args) {
		Lampadina lampadina = new Lampadina(5);

		int cicliProva = 6;

		try {

			for (int i = 0; i < cicliProva; i++) {
				System.out.println("Accendo...");
				System.out.println(lampadina.switchOn());
				System.out.println(lampadina.switchOff());
			}
			System.out.println("Eseguiti i cicli di prova");

		} catch (LampadinaBruciataException e) {
			e.printStackTrace();
		} finally {
			;
		}

	}

}
