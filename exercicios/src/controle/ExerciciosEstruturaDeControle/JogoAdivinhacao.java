package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class JogoAdivinhacao {public static void main(String[] args) {
	
	Scanner entrada = new Scanner(System.in);
	System.out.print("Tente adivinhaar um número de 0 a 100: ");
	int numero = entrada.nextInt();
	int numeroOculto = 50;
	if (numero >= 0 && numero <= 100) {
		for(int contador = 9;contador != 0;contador-- ) {
			if(numero > 100 || numero < 0) {
				System.out.print("\nNúmero fora do intervalo né? Não vale.");
				System.out.print("\nOk, vamos lá. Entre com um número: ");
				numero = entrada.nextInt();
			}
		if (numero > numeroOculto && numero >=0 && numero <=100) {
			System.out.printf("\n%d É maior que o número a ser adivinhado", numero);
			System.out.print("\nTente adivinhar novamente o número: ");
		 numero = entrada.nextInt();
		}
			
		
		else if (numero < numeroOculto && numero >=0 && numero <=100) {
			System.out.printf("\n%d é menor que o número a ser adivinhado", numero);
			System.out.print("\nTente adivinhar novamente o número: ");
			numero = entrada.nextInt();
		} 
		else if (numero == numeroOculto) {
			System.out.printf("\nParabéns, você acertou, o número é %d.", numeroOculto);
			break;
			}
		}
	}
	else {
		System.out.println("Número inválido.");
	}
	System.out.println("\nFim!");
	entrada.close();
	
}

}
