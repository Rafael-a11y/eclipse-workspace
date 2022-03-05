 package arrays;

import java.util.Scanner;

public class Desafio {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		
		System.out.print("Quantas notas são? ");
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
		System.out.println("A média é : " + (total / notasAluno.length));
		
		/*
		 * Estranho, ao tentar fazer total receber e somar os valores de nota, caso ela seja declarada dentro do
		 * for, dá erro, mas se total é declarado fora da estrutura, a atribuição e soma acontece normalmente.
		 * Pelo o que eu percebi, dentro de um for associado ao array, as saídas de texto acontecem uma embaixo 
		 * da outra, mesmo que seja um print e não println, caso seja usado println dentro do for associado ao
		 * array, os números inseridos aparecerão embaixo da String no console
		 */
		entrada.close();
	}

}
