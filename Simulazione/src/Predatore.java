
public class Predatore extends Animale {

	public Predatore() {
		super();
		CARATTERE = 'x';
	}

	public Cella spostamento() {
		switch (super.direzioneSpostamento()) {
		case Mondo.SU:
			if (cella.su != null && !(cella.su.animale instanceof Predatore)) {
				cella.animale = null;
				cella.su.animale = this;
				cella = cella.su;
			}
			break;
		case Mondo.DESTRA:
			if (cella.destra != null && !(cella.destra.animale instanceof Predatore)) {
				cella.animale = null;
				cella.destra.animale = this;
				cella = cella.destra;
			}
			break;
		case Mondo.GIU:
			if (cella.giu != null && !(cella.giu.animale instanceof Predatore)) {
				cella.animale = null;
				cella.giu.animale = this;
				cella = cella.giu;
			}
			break;
		case Mondo.SINISTRA:
			if (cella.sinistra != null && !(cella.sinistra.animale instanceof Predatore)) {
				cella.animale = null;
				cella.sinistra.animale = this;
				cella = cella.sinistra;

			}
			break;
		}
		return cella;
	}

	public void generazione() {
		int direzione = direzioneGenerazione();
		if (direzione > 0)
			switch (direzione) {
			case Mondo.SU:
				cella.su.animale = new Predatore();
				cella.su.animale.cella = cella.su;
				break;
			case Mondo.DESTRA:
				cella.destra.animale = new Predatore();
				cella.destra.animale.cella = cella.destra;
				break;
			case Mondo.GIU:
				cella.giu.animale = new Predatore();
				cella.giu.animale.cella = cella.giu;
				break;
			case Mondo.SINISTRA:
				cella.sinistra.animale = new Predatore();
				cella.sinistra.animale.cella = cella.sinistra;
				break;
			}
	}

	public void fame() {
		if (contapassi == 0) {
			cella.animale = null;
		}
	}

	public int incrementaPassi() {
		contapassi = (contapassi + 1) % 8;
		return contapassi;
	}
}
