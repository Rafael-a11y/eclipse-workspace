package exercicioParadigmas;

import java.util.InputMismatchException;
import java.util.Scanner;

	public class OperacoesBasicas {
		
		public static void main(String[] args) {
				
			Scanner entrada = new Scanner (System.in);
			
			double numero1 = 0;
			double numero2 = 0;
			try {
				System.out.println("Entre com um n�mero: ");
				numero1 = entrada.nextDouble();
				
				System.out.println("Entre com um segundo n�mero: ");
				numero2 = entrada.nextDouble();
			} 
			catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("Deve-se informar um n�mero, o valor est� " + 
				e.getMessage());
				
				System.out.println("Informe a opera��o aritim�tica (soma, subtra��o, divis�o ou multiplica��o) que deseja usar: ");
				String op = entrada.next();
				
				
				//L�gica -> Use os sinais para indicar a opera��o desejada
				
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
