import java.io.IOException;

public class Mondo {

	static final int SU = 0;
	static final int DESTRA = 1;
	static final int GIU = 2;
	static final int SINISTRA = 3;

	final int PREDE = 100;
	final int PREDATORI = 5;

	final int DIM = 20;

	Cella[][] mondo = new Cella[DIM][DIM];

	public Mondo() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				mondo[i][j] = new Cella();
			}
		}

		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				mondo[i][j].su = (i == 0) ? null : mondo[i - 1][j];
				mondo[i][j].destra = (j == (DIM - 1)) ? null : mondo[i][j + 1];
				mondo[i][j].giu = (i == (DIM - 1)) ? null : mondo[i + 1][j];
				mondo[i][j].sinistra = (j == 0) ? null : mondo[i][j - 1];
			}
		}

		for (int i = 0; i < PREDE; i++) {
			int x, y;
			do {
				x = (int) Math.ceil(Math.random() * 20 - 1);
				y = (int) Math.ceil(Math.random() * 20 - 1);
				// System.out.println("x: " + x + " - y: " + y);
			} while (mondo[x][y].animale != null);
			mondo[x][y].animale = new Preda();
			mondo[x][y].animale.cella = mondo[x][y];
		}

		for (int i = 0; i < PREDATORI; i++) {
			int x, y;
			do {
				x = (int) Math.ceil(Math.random() * 20 - 1);
				y = (int) Math.ceil(Math.random() * 20 - 1);
				// System.out.println("x: " + x + " - y: " + y);
			} while (mondo[x][y].animale != null);
			mondo[x][y].animale = new Predatore();
			mondo[x][y].animale.cella = mondo[x][y];
		}
	}

	public void avvia() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						dump();
						sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					for (int i = 0; i < DIM; i++) {
						for (int j = 0; j < DIM; j++) {
							if (mondo[i][j].animale != null) {
								Cella attuale = mondo[i][j];
								if (attuale.animale instanceof Predatore) {
									attuale = ((Predatore) attuale.animale).spostamento();
									((Predatore) attuale.animale).incrementaPassi();
									((Predatore) attuale.animale).generazione();
									((Predatore) attuale.animale).fame();
								}
							}
						}
					}

					for (int i = 0; i < DIM; i++) {
						for (int j = 0; j < DIM; j++) {
							if (mondo[i][j].animale != null) {
								Cella attuale = mondo[i][j];
								if (attuale.animale instanceof Preda) {
									attuale = ((Preda) attuale.animale).spostamento();
									((Preda) attuale.animale).incrementaPassi();
									((Preda) attuale.animale).generazione();
								}
							}
						}
					}
				}
			}
		}.start();

	}

	private void dump() {
		System.out.println("a");
		/*
		 * for (int i = 0; i < DIM; i++) { System.out.print("\r\n"); for (int j
		 * = 0; j < DIM; j++) System.out.print((mondo[i][j].animale == null) ?
		 * "-\t" : mondo[i][j].animale.CARATTERE + "\t"); } System.out .println(
		 * "\r\n------------------------------------------------------------------------------------------"
		 * );
		 */
	}

	public static void main(String[] pippo) {
		Mondo mondo = new Mondo();
		mondo.avvia();
	}
}
