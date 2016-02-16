package main;

import java.util.HashMap;

/**
 * Gestisce le parcelle dei propri Clienti.
 *
 */
public class Commercialista {

	private HashMap<Cliente, Integer> clienti;
	private int duplicati;

	public Commercialista() {
		clienti = new HashMap<>();
		duplicati = 0;
	}

	/**
	 * Calcola il totale delle parcelle di tutti i clienti univoci (ovvero NON
	 * vengono considerati le parcelle di eventuali clienti duplicati).
	 * 
	 * @return il totale delle parcelle
	 */
	public int totaleParcelle() {
		int totale = 0;

		for (Cliente c : clienti.keySet()) {
			if (clienti.get(c) == 1) {
				totale += c.calcolaParcella() * 100;
			}
		}

		return totale;
	}

	/**
	 * Inserisce un nuovo cliente, verificando che non sia già stato inserito.
	 * 
	 * @param d
	 *            dipendente
	 */
	public void addCliente(Cliente d) {
		if (!clienti.containsKey(d))
			clienti.put(d, 1);
		else {
			clienti.put(d, clienti.get(d) + 1);
			duplicati++;
		}
	}

	/**
	 * Restituisce il numero di volte che all'atto dell'inserimento di un
	 * cliente, il cliente era già stato inserito.
	 * 
	 * @return
	 */
	public int clientiDuplicati() {
		Integer num = 0;
		for (Cliente c : clienti.keySet()) {
			Integer numero = clienti.get(c);
			if (numero > 1)
				num += numero - 1;
		}
		return num.intValue();
	}

	/**
	 * Dato un cliente, restituisce il numero di volte che lo stesso cliente è
	 * stato inserito tramite le funzione addCliente. Nel caso che un dato
	 * cliente sia stato inserito una sola volta, restituisce il valore 1.
	 * 
	 * @param d
	 *            cliente da verificare
	 * @return numero di ripetizioni.
	 */
	public int numeroRipetizioni(Cliente d) {
		return clienti.get(d);
	}

}
