package giusti.damiano.videoteca;

public class FilmDVD extends Supporto {
	
	public int costoNoleggio(int numGiorni) {
		if (numGiorni < 1)
			return 0;

		if (numGiorni < 3)
			return 150 + costoNoleggio(numGiorni - 1);
		
		return 200 + costoNoleggio(numGiorni - 1);
	}

}
