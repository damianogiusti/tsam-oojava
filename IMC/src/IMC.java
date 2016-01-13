
public class IMC {

	public static void main(String[] args) {
		Persona damiano = new Persona(80, 1.8);
		Salute salute = new Salute();
		
		double imc = salute.calcoloIMC(damiano);
		String classeRischio = "";
		
		if (imc < 1.85)
			classeRischio = "sottopeso";
		else if (imc < 25)
			classeRischio = "normale";
		else if (imc < 30)
			classeRischio = "sovrappeso";
		else 
			classeRischio = "obeso";
		
		System.out.println(classeRischio);
	}

}
