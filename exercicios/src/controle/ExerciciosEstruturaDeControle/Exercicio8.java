package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class Exercicio8 {public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com uma palavra : ");
		String palavra = entrada.nextLine();
		char letras [] = palavra.toCharArray();
		for (int i = 0;i < letras.length;i++) {
			System.out.println(letras [i]);
			
		}
		
		entrada.close();
		/*
		 * char letras [] = palavra.toCharArray(); transforma String em char
		 */
}

}
