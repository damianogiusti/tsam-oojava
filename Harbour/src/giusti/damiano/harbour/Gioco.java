package giusti.damiano.harbour;

public class Gioco {

	PortoNavale porto;
	
	public Gioco() {
		porto = new PortoNavale();
		porto.setNome("Porto Navale");
		porto.setDimensioneMq(8000);
		porto.setNumAttacchi(0);
		porto.setNumeroImbarcazioni(30);
	}
	
	public Gioco(PortoNavale p) {
		this.porto = p;
	}
	
	public void attacca(Invasore[] invasori) {
		for (Invasore i : invasori) {
			porto.arrecaDanno(i.distruggiMq());;
		}
		porto.incrementaNumAttacchi();
	}
	
	public boolean isPortoDistrutto() {
		return porto.getDimensioneMq() > 0;
	}
		
	public PortoNavale getPorto() {
		return porto;
	}

	public void setPorto(PortoNavale porto) {
		this.porto = porto;
	}

	public static void main(String[] args) {
		
		Invasore[] invasori;
		Gioco gioco = new Gioco();
		
		invasori = new Invasore[5];
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				invasori[i] = new Sottomarino();
				((Sottomarino) invasori[i]).setId("" + (i + 1));
				((Sottomarino) invasori[i]).setModello("SM101");
				((Sottomarino) invasori[i]).setNumArmamenti(50);
				((Sottomarino) invasori[i]).setStazza(56);
			} else {
				invasori[i] = new Aereo();
				((Aereo)invasori[i]).setId("" + (i+1));
				((Aereo)invasori[i]).setModello("AE101");
				((Aereo)invasori[i]).setnArmamentiAlpha(25);
				((Aereo)invasori[i]).setnArmamentiBeta(10);
			}
		}
		
		while (!gioco.isPortoDistrutto()) {
			gioco.attacca(invasori);
		}
		
		System.out.println(gioco.getPorto().getNumAttacchi());
		
	}

}
