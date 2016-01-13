
public class Animale {
	int contapassi;
	Cella cella;
	char CARATTERE;

	public Animale() {
		contapassi = 0;
	}

	protected int direzioneSpostamento() {
		return (int) Math.floor(Math.random() * 4);
	}

	public int direzioneGenerazione() {
		if (contapassi == 0) {
			boolean[] occupati = new boolean[] { (cella.su == null || cella.su.animale != null),
					(cella.destra == null || cella.destra.animale != null),
					(cella.giu == null || cella.giu.animale != null),
					(cella.sinistra == null || cella.sinistra.animale != null) };

			int direzione;
			do {
				direzione = direzioneSpostamento();
			} while (occupati[direzione]);

			return direzione;
		}

		return -1;
	}
}
