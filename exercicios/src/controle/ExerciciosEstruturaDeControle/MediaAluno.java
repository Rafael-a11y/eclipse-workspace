package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class MediaAluno {public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	System.out.print("Entre com a nota da AV1: ");
	double AV1 = entrada.nextDouble();
	System.out.print("\nEntre com a nota da AV2: ");
	double AV2 = entrada.nextDouble();
	double media = (AV1 + AV2) / 2;
	if (media > 10 || media < 0) {
		System.out.println("Nota inválida");
	}
	else if (media >= 7) {
		System.out.println("Aprovado!");
	}
	else if (media < 7 && media >= 4) {
		System.out.println("de Recuperação");
	}
	else if (media < 4 && media >=0) {
		System.out.println("Reprovado :(");
	}
	entrada.close();
}

}
