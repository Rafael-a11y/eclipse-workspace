package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class NumeroPrimo {public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	System.out.print("Entre com um n�mero inteiro: ");
	int numero = entrada.nextInt();
	entrada.close();
		if (numero % 2 != 0 && numero % 3 != 0 && numero % 5 != 0 && numero % 7 != 0) {
		System.out.println("\n1� um n�mero primo...");
		}
		else if (numero == 2 || numero == 3 || numero == 5 || numero == 7) {
			System.out.println("2� um n�mero primo");
		}
		else {
			System.out.println("N�o � um n�mero primo");
		}
	
	
}

}
