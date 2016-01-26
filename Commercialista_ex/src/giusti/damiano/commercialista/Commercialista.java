package giusti.damiano.commercialista;

import minato.andrea.azienda.*;

public class Commercialista {

	private Azienda azienda;
	
	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	public static void main(String[] args) {
		
		Commercialista damiano = new Commercialista();
		
		Azienda minatosoft = new Azienda();
		minatosoft.setRagioneSociale("Minatosoft");
		minatosoft.setPiva("000000000001");
		
		ContrattoLavoro contratto = new ContrattoLavoro();
		contratto.setPagaBase(1300 * 100);
		contratto.setTipo("Sai te?");
		
		Dipendente[] dipendenti = new Dipendente[3];
		
		for (int i = 0; i<3; i++) {
			dipendenti[i] = new Dipendente();
			dipendenti[i].setNome("NomeDipendente" + (i+1));
			dipendenti[i].setCognome("CognomeDipendente" + (i+1));
			dipendenti[i].setContratto(contratto);
		}
		
		minatosoft.setDipendenti(dipendenti);
		
		System.out.println(minatosoft.getRagioneSociale() + " ha i seguenti dipendenti: ");
		for(Dipendente d : dipendenti) {
			System.out.println(d.getNome() + " " + d.getCognome());
			System.out.println("" + (d.stipendio() / 100) + "€");
			System.out.println("----------");
		}
		
	}

}
