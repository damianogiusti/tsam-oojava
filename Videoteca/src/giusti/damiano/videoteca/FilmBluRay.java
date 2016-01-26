package giusti.damiano.videoteca;

public class FilmBluRay extends Film {
	
	public FilmBluRay() {
		super();
	}
	
	public int costoNoleggio(int numGiorni) {
		if (numGiorni < 1)
			return 0;
		
		if (numGiorni == 1)
			return 1;
		
	}

}
