package giusti.damiano.videoteca;

/**
 * Classe astratta
 * Non posso creare un oggetto istanza della classe astratta
 * @author damiano
 *
 */
public abstract class Supporto {

	Film film;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	public abstract int costoNoleggio(int numGiorni);
}
