
public class Persona {

	double altezza;		// m
	double peso;		// kg
	int eta;		
	String attivitaFisica;
	char sesso;			// 'm' o 'f'
	
	public Persona(double h, double w, int a, String att, char s) {
		altezza = h;
		peso = w;
		eta = a;
		attivitaFisica = att.toLowerCase().trim();
		sesso = Character.toLowerCase(s);
	}
	
}
