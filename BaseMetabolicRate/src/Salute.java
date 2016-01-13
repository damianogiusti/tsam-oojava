
public class Salute {

	public double calcoloMB(Persona p) {
		double mb;
		if (p.sesso == 'f')
			mb = 655 + (9.6 * p.peso) + (1.8 * p.altezza) + (4.7 * p.eta);
		else
			mb = 655 + (13.8 * p.peso) + (1.8 * p.altezza) + (4.7 * p.eta);
		if (p.attivitaFisica.startsWith("sed"))
			return mb + mb * 0.2;
		if (p.attivitaFisica.startsWith("mod"))
			return mb + mb * 0.3;
		if (p.attivitaFisica.startsWith("att"))
			return mb + mb * 0.4;
		return mb + mb * 0.5;
	}
}
