package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class Teste {public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	System.out.print("Entre com um n�mero inteiro: ");
	int numero = entrada.nextInt();
	System.out.println("\nEntre com um segundo n�mero inteiro: ");
	int numero1 = entrada.nextInt();
	entrada.close();
	if ((numero + numero1 <= 30 && numero + numero1 >= 0)||(numero + numero1 == 32 || numero + numero1 == 40 || numero + numero1 == 50
			|| numero + numero1 == 60)) {
		System.out.printf("\nO n�mero %d � menor OU igual que 30, OU, � maior que 30 mas est� dentro de um dos valores que s�o aceitos"
				+ " fora do range", numero + numero1);
	}
//	else if (numero + numero1 == 32 || numero + numero1 == 40 || numero + numero1 == 50 || numero + numero1 == 60) {
//		System.out.printf("\nO n�mero %d � maior que 30 mas cai dentro dos valores aceitos fora do range.", numero + numero1);
	}

}


