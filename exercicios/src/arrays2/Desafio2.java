package arrays2;

import java.util.Scanner;

public class Desafio2 {
	
	public static void main(String[] args) {
			
	Scanner entrada = new Scanner(System.in);
	
	System.out.print("Entre com a quantidade de notas: ");
	
	int qtdNotas = entrada.nextInt();
	
	double notasAlunoA[] = new double [qtdNotas];
	
	for (int i = 0; i < notasAlunoA.length; i++) {
		System.out.print("\nEntre com a nota " + (i + 1) + ": ");
		notasAlunoA[i] = entrada.nextDouble();
	}
	
	double soma = 0;
	
	for(double notas: notasAlunoA) {
		System.out.println(notas);
		soma += notas;
	}
	
	System.out.println("A média final do aluno é: " + soma / notasAlunoA.length);
	entrada.close();
	
	}

}
