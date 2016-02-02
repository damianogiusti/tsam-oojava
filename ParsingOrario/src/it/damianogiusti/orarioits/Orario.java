package it.damianogiusti.orarioits;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Orario {

	public static void main(String[] args) {

		final int ORA_DA = 0;
		final int ORA_A = 1;
		final int DATA = 2;
		final int MATERIA = 4;
		final int DOCENTE = 5;

		ArrayList<Giornata> orario = new ArrayList<Giornata>();
		ArrayList<Giornata> orarioFinale = new ArrayList<Giornata>();

		if (args.length != 1)
			System.err.println("Expected 1 param: path to html file containing the fn orario");

		Document doc = null;
		try {
			doc = Jsoup.parse(new File(args[0]), "UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// documento non nullo, inizio procedura
		if (doc != null) {

			Element table = null;
			try {
				table = doc.getElementsByTag("table").get(0);
			} catch (Exception e) {
				System.err.println("Error while parsing table element: file path " + args[0]);
			}

			// inizio a leggere la tabella
			if (table != null) {
				for (Element tr : table.getElementsByTag("tr")) {
					int colonna = 0;
					Giornata g = new Giornata();

					for (Element td : tr.getElementsByTag("td")) {
						if (colonna != 3) {
							switch (colonna) {
							case ORA_DA:
								g.addOrari(td.text());
								break;
							case ORA_A:
								g.addOrari(td.text());
								break;
							case DATA:
								try {
									g.setData(td.text());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							case MATERIA:
								g.addMateria(td.text());
								break;
							case DOCENTE:
								g.addDocente(td.text());
								break;
							default:
								;
							}
						}

						colonna++;
					}
					orario.add(g);
				}
			} // fine lettura tabella
			
			
			// merge nell'orario definitivo
			for (int i = 0; i < orario.size() - 1; i++) {
				Giornata nuova = null;
				for (int j = i + 1; j < orario.size(); j++) {
					if (orario.get(i).getData().equals(orario.get(j).getData())) {
						nuova = Giornata.merge(orario.get(i), orario.get(j));
					}
				}
				if (nuova != null)
					orarioFinale.add(nuova);
				else
					orarioFinale.add(orario.get(i));
			} // fine merge
		} // fine procedura di parsing, ArrayList ORARIO popolata
		
		return;
		
		
	} // fine main

}
