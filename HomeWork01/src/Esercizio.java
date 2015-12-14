
public class Esercizio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Esercizio 1
	 * 
	 * Dato un array di interi, restituire la loro somma fino a che non viene
	 * ritrovato un valore
	 * 
	 * negativo.
	 */

	static double sum(double[] a) {
		int i = 0;
		double sum = 0;
		while (i < a.length && a[i] >= 0)
			sum += a[i];

		return sum;
	}

	/**
	 * 
	 * Esercizio 2
	 * 
	 * Dato un numero n, restituire la somma dei primi n numeri interi positivi
	 * dispari
	 */
	static double sumFirstN(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += 2 * n - 1;
		return sum;
	}

	/**
	 * 
	 * Esercizio 3
	 * 
	 * Dato un array di 10 elementi, calcolarne la media
	 */
	static double avg(double[] a) {
		double avg = 0;
		for (double d : a)
			avg += d / a.length;

		return avg;
	}

	/**
	 * 
	 * Esercizio 4
	 * 
	 * Dato un intervallo [a, b] con a e b due interi positivi, restituire la
	 * somma di tutti i numeri
	 * 
	 * compresi all’interno dell’intervallo, estremi inclusi. Nel caso che b
	 * sia minore di a,
	 * 
	 * calcolare la somma nell’intervallo [b,a]
	 * 
	 * Esempio:
	 * 
	 * sumInterval(3, 5) => 12
	 * 
	 * sumInterval(5, 3) => 12
	 */
	static double sumInterval(double a, double b) {
		double max = Math.max(a, b);
		double min = Math.min(a, b);
		double sum = 0;

		while (min <= max)
			sum += min++;
		return sum;
	}

	/**
	 * 
	 * Esercizio 5
	 * 
	 * Si calcoli il prodotto di due numeri a, b maggiori o uguali a zero,
	 * tramite l’utilizzo del solo
	 * 
	 * operatore somma.
	 * 
	 * Esempio:
	 * 
	 * mult(2, 3) => 6
	 */

	static double mul(double a, double b) {
		double result = 0;
		for (int i = 0; i < a; i++)
			result += b;
		return result;
	}

	/**
	 * Esercizio 6
	 * 
	 * Si calcoli la divisione e il resto della divisione tra due numeri a, b
	 * maggiori a zero, tramite
	 * 
	 * l’utilizzo dei soli operatori somma e sottrazione.
	 * 
	 * Esempio:
	 * 
	 * div(5, 3) => 1 resto 2
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int[] div(double a, double b) {
		int quot = 0;
		int remainder = 0;

		while ((a - b) >= 0) {
			a -= b;
			quot++;
		}

		remainder = (int) a;

		return new int[] { quot, remainder };
	}

}
