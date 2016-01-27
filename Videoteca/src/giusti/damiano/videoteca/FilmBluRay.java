package giusti.damiano.videoteca;

public class FilmBluRay extends Supporto {

	public int costoNoleggio(int numGiorni) {
		
		float penale = 0.1f;
		
		if (numGiorni < 1)
			return 0;
		
		if (numGiorni == 1)
			return 100;
		
		return Math.round(costoNoleggio(numGiorni - 1) * (1 + penale));
	}

}
