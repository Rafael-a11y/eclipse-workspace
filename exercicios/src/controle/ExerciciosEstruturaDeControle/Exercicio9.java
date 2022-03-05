package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class Exercicio9 {public static void main(String[] args) {
	
	Scanner entrada = new Scanner(System.in);
	int numero = 0;
	int acumulador = 0;
		
			for(int contador = 1; contador <= 10;contador++) {
				System.out.println("Entre com um número: ");
				numero = entrada.nextInt();
				if (numero >acumulador) {
					acumulador = numero;
				}
			
		}
		entrada.close();
		System.out.println("número vale : " + acumulador);
		System.out.println("Fim");
		
	}
}


