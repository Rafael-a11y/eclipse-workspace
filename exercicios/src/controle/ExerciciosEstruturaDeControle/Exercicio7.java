package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class Exercicio7 {public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	int contadorDeNumeros = 0;
	int numero = 70;
	while (numero >= 0) {
		System.out.print("\nEntre com um número:  ");
		 numero = entrada.nextInt();
		 if(numero >= 0) {
			 contadorDeNumeros += numero;
			 System.out.printf("A soma é: %d", contadorDeNumeros);
		 }
	}
	entrada.close();
}

}
