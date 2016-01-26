package giusti.damiano.videoteca;

public class FilmCassetta extends Film {
	
	public FilmCassetta() {
		super();
	}
	
	public int costoNoleggio(int numGiorni) {
		if (numGiorni < 1)
			return 0;
		if (numGiorni == 1) 
			return 100;
		
		return 200 + costoNoleggio(numGiorni - 1);
	}

}
