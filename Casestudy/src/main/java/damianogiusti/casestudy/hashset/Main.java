package damianogiusti.casestudy.hashset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

class WrongParametersException extends RuntimeException {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "expected two integer (interval of rows to split) and a string (Google Api key)";
	}
}

public class Main {

	/**
	 * 
	 * @param args
	 *            <br>
	 *            [0] da <br>
	 *            [1] a <br>
	 *            [2] googlekey
	 */
	public static void main(String[] args) {

		if (args.length != 3)
			throw new WrongParametersException();
		if (Integer.valueOf(args[0].trim()) == null || Integer.valueOf(args[1].trim()) == null || args[2] == null
				|| args[2].trim().equals(""))
			throw new WrongParametersException();

		int righeDa = Integer.valueOf(args[0]);
		int righeA = Integer.valueOf(args[1]);
		String googlekey = args[2];

		FileReader fr = null;
		BufferedReader buffer = null;
		try {

			fr = new FileReader("dati.csv");
			buffer = new BufferedReader(fr);

			String riga;
			int contatoreId = 0;
			TreeMap<Location, List<Integer>> map = new TreeMap<Location, List<Integer>>() {

				@Override
				public List<Integer> put(Location key, List<Integer> value) {
					if (this.containsKey(key)) {
						super.get(key).add(value.get(0)); // avrà sempre e solo
															// un
															// elemento
						return super.get(key);
					}
					return super.put(key, value);
				}
			};

			/*
			 * Gli elementi che mi interessano sono in posizione [2] [3] [4]
			 */
			while ((riga = myReadLine(buffer)) != null && contatoreId < righeA) {
				if (contatoreId == 0 || contatoreId < (righeDa))
					++contatoreId;
				else {
					String[] address = riga.split(";");
					map.put(new Location(address[2], address[3], address[4]),
							new LinkedList<Integer>(Arrays.asList(++contatoreId)));
				}
				// System.out.println("\r\n" + (contatoreId) + ";" + riga);
			}

			try {
				okGoogle(map, googlekey);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			writeGoogleDatas(map);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (buffer != null)
					buffer.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Legge una linea senza fermarsi se incontra \t
	 * 
	 * @param buffer
	 * @return la linea letta in stringa
	 * @throws IOException
	 */
	private static String myReadLine(BufferedReader buffer) throws IOException {
		String result = "";
		int c;
		do {
			c = buffer.read();
			if (c >= 0 && c <= 255) {
				result += String.valueOf((char) c);
			}
		} while (c > -1 && c != '\r');
		if (c == -1)
			result = null;
		return result;
	}

	private static void showMap(TreeMap<Location, List<Integer>> map) {

		for (Address key : map.keySet()) {
			List<Integer> list = map.get(key);
			System.out.print("{ " + key.toString() + ": [");
			for (Integer i : list) {
				System.out.print(" " + i + " ");
			}
			System.out.println("] }");
		}
		System.out.println("Size of map: " + map.size());
	}

	private static void okGoogle(TreeMap<Location, List<Integer>> map, String googlekey) throws Exception {

		GeoApiContext context = new GeoApiContext().setApiKey(googlekey);

		for (Location key : map.keySet()) {
			GeocodingResult[] results = GeocodingApi.geocode(context, key.toString()).await();

			key.setLat(results[0].geometry.location.lat);
			key.setLng(results[0].geometry.location.lng);
			key.setGoogleAddress(results[0].formattedAddress);

			System.out.println(key.getLat() + " " + key.getLng() + " " + key.getGoogleAddress());
		}
	}

	private static void writeGoogleDatas(TreeMap<Location, List<Integer>> map) throws IOException {

		FileWriter fw = new FileWriter("googleOutput.csv");
		PrintWriter pw = new PrintWriter(fw);

		for (Location key : map.keySet()) {
			for (Integer i : map.get(key)) {
				pw.println("" + i + ";" + key.getLat() + ";" + key.getLng() + ";" + key.getGoogleAddress());
			}
		}
		
		pw.close();
		fw.close();
	}
}
