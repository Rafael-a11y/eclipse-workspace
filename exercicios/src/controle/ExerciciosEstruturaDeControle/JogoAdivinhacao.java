package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class JogoAdivinhacao {public static void main(String[] args) {
	
	Scanner entrada = new Scanner(System.in);
	System.out.print("Tente adivinhaar um n�mero de 0 a 100: ");
	int numero = entrada.nextInt();
	int numeroOculto = 50;
	if (numero >= 0 && numero <= 100) {
		for(int contador = 9;contador != 0;contador-- ) {
			if(numero > 100 || numero < 0) {
				System.out.print("\nN�mero fora do intervalo n�? N�o vale.");
				System.out.print("\nOk, vamos l�. Entre com um n�mero: ");
				numero = entrada.nextInt();
			}
		if (numero > numeroOculto && numero >=0 && numero <=100) {
			System.out.printf("\n%d � maior que o n�mero a ser adivinhado", numero);
			System.out.print("\nTente adivinhar novamente o n�mero: ");
		 numero = entrada.nextInt();
		}
			
		
		else if (numero < numeroOculto && numero >=0 && numero <=100) {
			System.out.printf("\n%d � menor que o n�mero a ser adivinhado", numero);
			System.out.print("\nTente adivinhar novamente o n�mero: ");
			numero = entrada.nextInt();
		} 
		else if (numero == numeroOculto) {
			System.out.printf("\nParab�ns, voc� acertou, o n�mero � %d.", numeroOculto);
			break;
			}
		}
	}
	else {
		System.out.println("N�mero inv�lido.");
	}
	System.out.println("\nFim!");
	entrada.close();
	
}

}
