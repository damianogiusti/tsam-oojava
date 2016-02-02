package it.damianogiusti.orarioits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Giornata {

	private Date data;
	private String[] materie;
	private String[] orari;
	private String[] docenti;

	public Giornata() {
		data = null;
		materie = new String[2];
		orari = new String[2];
		docenti = new String[2];
	}

	public Giornata(String data) throws ParseException {
		this.setData(data);
		materie = new String[2];
		orari = new String[2];
		docenti = new String[2];
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setData(String data) throws ParseException {
		if (data.contains(" "))
			data = data.split(" ")[0];

		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yy");
		this.data = sdf.parse(data);
	}

	public String[] getMaterie() {
		return materie;
	}

	public void setMaterie(String[] materie) {
		this.materie = materie;
	}

	public void addMateria(String materia) {
		if (orari[0] != null)
			materie[0] = materia;
		else if (orari[1] != null)
			materie[1] = materia;
	}

	public void addOrari(String ora) {
		String nuovaOra = (ora.length() == 4) ? "0" + ora.replace(",", ":") : ora.replace(",", ":");
		if (Math.round(Float.parseFloat(ora.replace(",", "."))) < 14) {
			if (orari[0] == null)
				orari[0] = nuovaOra;
			else if (orari[0].length() > 0)
				orari[0] += " - " + nuovaOra;
		} else {
			if (orari[1] == null)
				orari[1] = nuovaOra;
			else if (orari[1].length() > 0)
				orari[1] += " - " + nuovaOra;
		}
	}

	public String[] getOrari() {
		return orari;
	}

	public void setOrari(String[] orari) {
		this.orari = orari;
	}

	public String[] getDocenti() {
		return docenti;
	}

	public void setDocenti(String[] docenti) {
		this.docenti = docenti;
	}

	public void addDocente(String docente) {
		if (materie[0] != null)
			docenti[0] = docente;
		else if (materie[1] != null)
			docenti[1] = docente;
	}

	public String toHtml() {
		String html = "<td>";
		if (materie[0] != null) {
			html += "<span class=\"materia\">" + materie[0] + "</span><br/><span class=\"orario\">" + orari[0]
					+ "</span><br/><span class=\"docente\">" + docenti[0] + "</span><br/>";
		}
		if (materie[1] != null) {
			html += "<span class=\"materia\">" + materie[1] + "</span><br/><span class=\"orario\">" + orari[1]
					+ "</span><br/><span class=\"docente\">" + docenti[1] + "</span>";
		}
		html += "</td>";
		return html;
	}

	public static Giornata merge(Giornata g1, Giornata g2) {
		Giornata g = new Giornata();

		Giornata mattina, pomeriggio;

		if (g1.getOrari()[0] != null && g2.getOrari()[1] != null) {
			mattina = g1;
			pomeriggio = g2;
		} else {
			mattina = g2;
			pomeriggio = g1;
		}

		g.setOrari(new String[] { mattina.getOrari()[0], pomeriggio.getOrari()[1] });
		g.setMaterie(new String[] { mattina.getMaterie()[0], pomeriggio.getMaterie()[1] });
		g.setDocenti(new String[] { mattina.getDocenti()[0], pomeriggio.getDocenti()[1] });
		g.setData(g1.getData());

		return g;
	}

}
