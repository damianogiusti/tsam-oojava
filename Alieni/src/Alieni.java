import java.util.ArrayList;
import java.util.List;

public class Alieni {

	public static void main(String[] args) {
		Giocatore damiano = new Giocatore("Damiano", 100);
		List<Alieno> alieni = new ArrayList<Alieno>();

		for (int i = 0; i < 4; i++) {
			alieni.add(new Alieno("Alieno" + (i+1), 20));
		}
		
		Gioco gioco = new Gioco(damiano);
		gioco.gioca(alieni);
		System.out.println(gioco.isGameOver());
	}

}
