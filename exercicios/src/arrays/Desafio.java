 package arrays;

import java.util.Scanner;

public class Desafio {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		
		System.out.print("Quantas notas s�o? ");
		int qtdNotas = entrada.nextInt();
		
		double notasAluno [] = new double [qtdNotas];
		
		for (int i = 0; i < notasAluno.length; i++) {
			System.out.println("Informe a nota "  + (i + 1) + ": ");
			notasAluno[i] = entrada.nextDouble();
		}
		
		double total = 0;
		for(double nota: notasAluno) {
			 total += nota;
		}
		System.out.println("A m�dia � : " + (total / notasAluno.length));
		
		/*
		 * Estranho, ao tentar fazer total receber e somar os valores de nota, caso ela seja declarada dentro do
		 * for, d� erro, mas se total � declarado fora da estrutura, a atribui��o e soma acontece normalmente.
		 * Pelo o que eu percebi, dentro de um for associado ao array, as sa�das de texto acontecem uma embaixo 
		 * da outra, mesmo que seja um print e n�o println, caso seja usado println dentro do for associado ao
		 * array, os n�meros inseridos aparecer�o embaixo da String no console
		 */
		entrada.close();
	}

}
