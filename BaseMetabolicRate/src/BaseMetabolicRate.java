
public class BaseMetabolicRate {

	public static void main(String[] args) {

		Persona damiano = new Persona(180, 80, 20, "sedentario", 'm');
		Salute salute = new Salute();
		System.out.println(salute.calcoloMB(damiano));
	}

}
