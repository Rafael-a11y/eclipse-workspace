package controle;

import java.util.Scanner;

public class WhileIndeterminado {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		String palavra = "";
		while (!palavra.equalsIgnoreCase("sair")) {
			System.out.print("\nVocê diz: ");
			palavra = entrada.nextLine();
		}
		System.out.println("Fim!");
		entrada.close();
		
//		OU
//		
//	Scanner entrada = new Scanner (System.in);
//		System.out.print("Entre com uma palavra ou frase: ");
//		String palavra = entrada.next();
//		
//		while (!palavra .equalsIgnoreCase("sair")) {
//			System.out.print("\nentre com uma palavra ou frase: ");
//			palavra = entrada.nextLine();
//		}
//		System.out.println("\nFim!");
//		entrada.close();
	}

}
