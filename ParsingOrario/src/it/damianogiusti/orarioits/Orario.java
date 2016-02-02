package it.damianogiusti.orarioits;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.jsoup.*;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import sun.rmi.runtime.Log;

public class Orario {

	public static void main(String[] args) {

		final int ORA_DA = 0;
		final int ORA_A = 1;
		final int DATA = 2;
		final int MATERIA = 4;
		final int DOCENTE = 5;

		ArrayList<Giornata> orario = new ArrayList<Giornata>();
		ArrayList<Giornata> orarioFinale = new ArrayList<Giornata>();

		if (args.length != 1) {
			System.err.println("Expected 1 param: path to html file containing the fuckin orario");
			return;
		}

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
			Date dataUltimoInserito = null;
			for (int i = 0; i < orario.size(); i++) {
				Giornata nuova = null;
				for (int j = i + 1; j < orario.size() - 1; j++) {
					if (orario.get(i).getData().equals(orario.get(j).getData())) {
						nuova = Giornata.merge(orario.get(i), orario.get(j));
						break;
					}
				}

				if (nuova != null) {
					orarioFinale.add(nuova);
					nuova = null;
					dataUltimoInserito = orario.get(i).getData();
				} else if (dataUltimoInserito == null) {
					orarioFinale.add(orario.get(i));
					dataUltimoInserito = orario.get(i).getData();
				} else if (dataUltimoInserito != null && !orario.get(i).getData().equals(dataUltimoInserito)) {
					orarioFinale.add(orario.get(i));
					dataUltimoInserito = orario.get(i).getData();
				}

			} // fine merge
		} // fine procedura di parsing, ArrayList ORARIO popolata

		Document template = null;
		try {
			template = Jsoup.parse(new File("/home/damiano/Scrivania/template.html"), "UTF-8");
		} catch (Exception e) {

		}
		Element tbody = template.getElementsByTag("tbody").get(0);

		Collections.sort(orarioFinale, new Comparator<Giornata>() {
			@Override
			public int compare(Giornata o1, Giornata o2) {
				return o1.getData().compareTo(o2.getData());
			}
		});

		SimpleDateFormat sdfDayOfWeek = new SimpleDateFormat("u");
		SimpleDateFormat sdfDayOfMonth = new SimpleDateFormat("d");
		
		int gap = 0;
		boolean primo = true;
		for (Giornata g : orarioFinale) {
			int numeroGiorno = Integer.parseInt(sdfDayOfWeek.format(g.getData()));
			gap = numeroGiorno - gap;

			if (numeroGiorno == 1) {
				/*if (!primo)
					tbody.append("</tr>");
				if (primo)
					primo = false;
*/
				tbody = tbody.append("<tr>");
				
			}

			// se tra una giornata e l'altra ho solo un giorno di differenza
			if (gap == 1) {
				// inserisco la giornata in HTML
				tbody.append(g.toHtml());
			}
			// se tra una giornata e l'altra ho piu giorni
			else {
				// riempio gli spazi vuoti
				for (int i = 1; i < gap; i++) {
					tbody.append("<td>");
				}
			}
		}

		System.out.println(template.html());

	} // fine main

}
