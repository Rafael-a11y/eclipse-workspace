package exercicioParadigmas;

import java.util.InputMismatchException;
import java.util.Scanner;

	public class OperacoesBasicas {
		
		public static void main(String[] args) {
				
			Scanner entrada = new Scanner (System.in);
			
			double numero1 = 0;
			double numero2 = 0;
			try {
				System.out.println("Entre com um número: ");
				numero1 = entrada.nextDouble();
				
				System.out.println("Entre com um segundo número: ");
				numero2 = entrada.nextDouble();
			} 
			catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("Deve-se informar um número, o valor está " + 
				e.getMessage());
				
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


	}
