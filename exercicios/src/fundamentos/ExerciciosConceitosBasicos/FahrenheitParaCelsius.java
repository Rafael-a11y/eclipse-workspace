package fundamentos.ExerciciosConceitosBasicos;

import java.util.Scanner;

public class FahrenheitParaCelsius {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com a temperatura em fahrenheit: ");
		float fahrenheit = (float) entrada.nextFloat();
		final float formula = (float) ((fahrenheit - 32) * 5/9);
		entrada.close();
		
		System.out.printf("A temperatura em Celsius é %.5fºC", formula);

		
	}
	
	

}
