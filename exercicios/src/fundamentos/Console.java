package fundamentos;

import java.util.Scanner;

public class Console {
public static void main(String[] args) {
	System.out.print("Bom");
	System.out.println(" dia\n\n");
	
	System.out.println("Bom");
	System.out.println("dia");
	
	System.out.printf("Megasena: %d %d %d %d %d %d %n",
			1, 2, 3, 4, 5, 6);
	/*
	 * Note que na formatação acima, os caracteres são substituídos
	 * neste caso acima, %n representa quebra de linha
	 */
	System.out.printf("Salário: %.1f%n", 1234.5678);
	System.out.printf("Nome : %s%n", "João");
	/*
	 * %s String de caracters
	 * %d número inteiro decimal
	 * %u Número inteiro decimal sem sinal
	 * %o Número inteiro octal sem sinal
	 * %x %X Número inteiro hexadecimal sem sinal, maiúsculo 
	 * ou minúsculo
	 * %f float
	 * %2f double
	 * %e %E Número real, em notação científica, maiúsculo ou minúsculo
	 * %b boolean 
	 * %c char
	 */
	Scanner entrada = new Scanner(System.in); //Escanear a entrada via teclado
	
	System.out.print("Digite o seu nome: ");
	String nome = entrada.nextLine();			//Inserir dado String via teclado na próxima linha
												//Dado inserido
	System.out.println("\n\nNome: " + nome);	//Mostrar dado inserido
	
	System.out.print("Digite o seu sobrenome: ");
	String sobrenome = entrada.nextLine();
	
	System.out.print("Digite a sua idade: ");
	int idade = entrada.nextInt();				//Inserir dado int via teclado na próxima linha, observe que agora o método usado é nextInt para inserir um dado int
	
	System.out.printf("%s %s tem %d anos.",
			nome, sobrenome, idade);
	
	entrada.close();							//Fechar Scanner
	
	
	
}

}

