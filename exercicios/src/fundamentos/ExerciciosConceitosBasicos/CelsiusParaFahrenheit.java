package fundamentos.ExerciciosConceitosBasicos;

import java.util.Scanner;

public class CelsiusParaFahrenheit {
	
	public static void main(String[] args) {
		
	Scanner entrada = new Scanner (System.in);
	System.out.print("Entre com a temperatura em Celsius: ");
	double celsius = entrada.nextDouble();
	double formula = (celsius * 9/5) + 32;
	entrada.close();
	System.out.print("\nA temperaturaem em Fahrenheit é " + formula);
	
	}

}
