package fundamentos;

import java.util.Scanner;

public class DesafioCalculadoraResposta {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Entre com um número: ");
		double numero1 = entrada.nextDouble();
		
		System.out.println("Entre com um segundo número: ");
		double numero2 = entrada.nextDouble();
		
		System.out.println("Informe a operação aritimética (soma, subtração, divisão ou multiplicação) que deseja usar: ");
		String op = entrada.next();
		
		
		//Lógica -> Use os sinais para indicar a operação desejada
		
		double resultado = "+".equals(op) ? numero1 + numero2 : 0;
		resultado = "-".equals(op) ? numero1 - numero2 : resultado;
		resultado = "*".equals(op) ? numero1 * numero2 : resultado;
		resultado = "/".equals(op) ? numero1 / numero2 : resultado;
		resultado = "%".equals(op) ? numero1 % numero2 : resultado;
		
		System.out.printf("%.2f %s %.2f = %.2f", numero1, op, numero2, resultado);
		
		entrada.close();
		
	}

}
