package giusti.damiano.esericiziomappe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.security.ssl.HandshakeOutStream;

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
		return false;
	}

	@Override
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}

public class Main {

	// dato un array di person
	// creare un hashmap e un treemap
	// che permetta di contare quante persone "equals" ci sono
	// nell'array.

	// Esempio:
	// ["pippo", "pluto", "pippo", "gigi"]
	// {"pippo":2, "pluto":1, "gigi": 1}

	public static void main(String[] args) {
		List<Person> persone = Arrays.asList(new Person("pippo"), new Person("pluto"), new Person("pippo"),
				new Person("gigi"));

		Map<Person, Integer> hashmap = new HashMap<Person, Integer>() {

			@Override
			public Integer put(Person key, Integer value) {
				if (this.containsKey(key))
					return super.put(key, this.get(key) + 1);
				return super.put(key, 1);
			}

		};
		for (Person p : persone) {
			hashmap.put(p, null);
		}
		
		
		System.out.print("{");
		for (Person p : hashmap.keySet()) {
			System.out.print(" \"" + p.getNome() + "\" : " + hashmap.get(p) + " ");
		}
		System.out.print("}");
		
	}
}
