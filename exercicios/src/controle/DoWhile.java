package controle;

import java.util.Scanner;

public class DoWhile {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		String texto = "";
		do {
			System.out.print("Voc� precisa dizer as palavras m�gicas... ");
			System.out.print("\nQuer sair? ");
			texto = entrada.nextLine();
		} while (!texto.equalsIgnoreCase("por favor"));
		System.out.println("Obrigado!");
		entrada.close();
		/*
		 * DO {
		 * 
		 * } WHILE (EXPRESS�O);
		 * 
		 * DO WHILE USA ; NO FINAL E � A �NICA ESTRUTURA DE CONTROLE ONDE A CONDI��O DE C�DIGO � EXECUTADA  PELO MENOS UMA VEZ
		 */
	}

}
