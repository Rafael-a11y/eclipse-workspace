package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class Exercicio1 {
		public static void main(String[] args) {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Entre com o número: ");
			int numero = entrada.nextInt();
			if (numero % 2 == 0 && numero > -1 && numero < 11) {
				System.out.println("Número par.");
		}
			else if (numero % 2 == 1 && numero > -1 && numero < 11) {
				System.out.println("Numero ímpar.");
		}
			else {
				System.out.println("Número fora do range de 0 a 10");
			}
	
	}
}

