
public class CambiaMonete {

	int valore;
	static int[] soldi = new int[] { 500, 200, 100, 50, 20, 10, 5, 2, 1 };

	public CambiaMonete(int valore) {
		this.valore = valore;
	}

	private int[] calcoloMonete() {
		int[] quantita = new int[soldi.length];
		int valore2 = valore;

		for (int i = 0; i < soldi.length; i++) {
			while (soldi[i] <= valore2) {
				valore2 -= soldi[i];
				quantita[i]++;
			}
		}

		return quantita;
	}

	public static void main(String[] args) {
		CambiaMonete cm = new CambiaMonete(1407);

		int[] qta = cm.calcoloMonete();
		for (int i = 0; i < qta.length; i++) {
			if (qta[i] > 0)
				System.out.println("" + qta[i] + " da " + CambiaMonete.soldi[i]);
		}

	}

}
