package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class Exercicio1 {
		public static void main(String[] args) {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Entre com o n�mero: ");
			int numero = entrada.nextInt();
			if (numero % 2 == 0 && numero > -1 && numero < 11) {
				System.out.println("N�mero par.");
		}
			else if (numero % 2 == 1 && numero > -1 && numero < 11) {
				System.out.println("Numero �mpar.");
		}
			else {
				System.out.println("N�mero fora do range de 0 a 10");
			}
	
	}
}

