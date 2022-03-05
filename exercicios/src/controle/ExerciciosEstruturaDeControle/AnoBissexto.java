package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class AnoBissexto {public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	System.out.print("Entre com um número: ");
	int numero = entrada.nextInt();
	if (numero % 4 == 0 && numero % 100 != 0) {
		System.out.println("O ano é bissexto");
	}
	else if (numero % 4 != 0 && numero % 400 == 0) {
		System.out.println("O ano é bissexto");
	}
	else {
		System.out.println("O ano não é bissexto");
	}
	entrada.close();
}

}
