import java.util.List;

public class Gioco {
	
	Giocatore giocatore;
	
	public Gioco(Giocatore g) {
		giocatore = g;
	}
	
	public void gioca(List<Alieno> alieni) {
		for (Alieno alieno : alieni) {
			giocatore.salute -= alieno.danno;
		}
	}
	
	public boolean isGameOver() {
		return giocatore.salute <= 0;
	}
}
