package controle;

import java.util.Scanner;

public class DoWhile {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		String texto = "";
		do {
			System.out.print("Você precisa dizer as palavras mágicas... ");
			System.out.print("\nQuer sair? ");
			texto = entrada.nextLine();
		} while (!texto.equalsIgnoreCase("por favor"));
		System.out.println("Obrigado!");
		entrada.close();
		/*
		 * DO {
		 * 
		 * } WHILE (EXPRESSÃO);
		 * 
		 * DO WHILE USA ; NO FINAL E É A ÚNICA ESTRUTURA DE CONTROLE ONDE A CONDIÇÃO DE CÓDIGO É EXECUTADA  PELO MENOS UMA VEZ
		 */
	}

}
