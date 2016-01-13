
public class Preda extends Animale {

	public Preda() {
		super();
		CARATTERE = 'o';
	}

	public Cella spostamento() {
		switch (super.direzioneSpostamento()) {
		case Mondo.SU:
			if (cella.su != null && cella.su.animale == null) {
				cella.animale = null;
				cella.su.animale = this;
				cella = cella.su;
			}
			break;
		case Mondo.DESTRA:
			if (cella.destra != null && cella.destra.animale == null) {
				cella.animale = null;
				cella.destra.animale = this;
				cella = cella.destra;
			}
			break;
		case Mondo.GIU:
			if (cella.giu != null && cella.giu.animale == null) {
				cella.animale = null;
				cella.giu.animale = this;
				cella = cella.giu;
			}
			break;
		case Mondo.SINISTRA:
			if (cella.sinistra != null && cella.sinistra.animale == null) {
				cella.animale = null;
				cella.sinistra.animale = this;
				cella = cella.sinistra;
			}
		}
		return cella;
	}

	public void generazione() {
		int direzione = direzioneGenerazione();
		if (direzione > 0)
			switch (direzione) {
			case Mondo.SU:
				cella.su.animale = new Preda();
				cella.su.animale.cella = cella.su;
				break;
			case Mondo.DESTRA:
				cella.destra.animale = new Preda();
				cella.destra.animale.cella = cella.destra;
				break;
			case Mondo.GIU:
				cella.giu.animale = new Preda();
				cella.giu.animale.cella = cella.giu;
				break;
			case Mondo.SINISTRA:
				cella.sinistra.animale = new Preda();
				cella.sinistra.animale.cella = cella.sinistra;
				break;
			}
	}

	public int incrementaPassi() {
		contapassi = (contapassi + 1) % 3;
		return contapassi;
	}

}
