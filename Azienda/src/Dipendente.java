
public class Dipendente {
	String nome;
	String cognome;
	int anzianita;
	Contratto contratto;

	public Dipendente(String n, String c, int a, Contratto ctr) {
		nome = n;
		cognome = c;
		anzianita = a;
		contratto = ctr;
	}

	public double stipendio() {
		return contratto.stipendioBaseAnnuo + ((contratto.stipendioBaseAnnuo * 0.005) * anzianita);
	}
}
