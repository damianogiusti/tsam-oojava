package giusti.damiano.esericiziomappe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Person implements Comparable<Person> {

	private String nome;

	public Person(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Person))
			return false;

		Person persona = (Person) p;
		if (persona.getNome() == null)
			return this.nome == null;

		return this.nome.equals(persona.nome);
	}

	@Override
	public int compareTo(Person p) {
		return nome.compareTo(p.getNome());
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}
}

public class Main {

	// dato un array di person
	// creare un hashmap e un treemap
	// che permetta di contare quante persone "equals" ci sono
	// nell'array.

	// Esempio:
	// ["pippo", "pluto", "pippo", "gigi"]
	// {"pippo" : 2, "pluto" : 1, "gigi" : 1}

	public static void main(String[] args) {
		List<Person> persone = Arrays.asList(new Person("pippo"), new Person("pluto"), new Person("pippo"),
				new Person("gigi"));

		HASHMAP: {
			Map<Person, Integer> hashmap = new HashMap<Person, Integer>() {
				@Override
				public Integer put(Person key, Integer value) {
					if (this.containsKey(key))
						return super.put(key, this.get(key) + 1);
					return super.put(key, 1);
				}
			};

			// iteratore usato al posto del foreach
			Iterator<Person> iter = persone.iterator();
			while (iter.hasNext()) {
				Person p = iter.next();
				hashmap.put(p, null);
			}

			// mostro i risultati "serializzati"
			System.out.print("{");
			for (Person p : hashmap.keySet()) {
				System.out.print(" \"" + p.getNome() + "\" : " + hashmap.get(p) + " ");
			}
			System.out.println("}");
		}

		TREEMAP: {
			Map<Person, Integer> treemap = new TreeMap<Person, Integer>() {

				@Override
				public Integer put(Person key, Integer value) {
					if (this.containsKey(key))
						return super.put(key, this.get(key) + 1);
					return super.put(key, 1);
				}

			};

			// iteratore usato al posto del foreach
			Iterator<Person> iter = persone.iterator();
			while (iter.hasNext()) {
				Person p = iter.next();
				treemap.put(p, null);
			}

			// mostro i risultati "serializzati"
			System.out.print("{");
			for (Person p : treemap.keySet()) {
				System.out.print(" \"" + p.getNome() + "\" : " + treemap.get(p) + " ");
			}
			System.out.println("}");

		}
	}
}
