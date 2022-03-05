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
	 * Note que na formata��o acima, os caracteres s�o substitu�dos
	 * neste caso acima, %n representa quebra de linha
	 */
	System.out.printf("Sal�rio: %.1f%n", 1234.5678);
	System.out.printf("Nome : %s%n", "Jo�o");
	/*
	 * %s String de caracters
	 * %d n�mero inteiro decimal
	 * %u N�mero inteiro decimal sem sinal
	 * %o N�mero inteiro octal sem sinal
	 * %x %X N�mero inteiro hexadecimal sem sinal, mai�sculo 
	 * ou min�sculo
	 * %f float
	 * %2f double
	 * %e %E N�mero real, em nota��o cient�fica, mai�sculo ou min�sculo
	 * %b boolean 
	 * %c char
	 */
	Scanner entrada = new Scanner(System.in); //Escanear a entrada via teclado
	
	System.out.print("Digite o seu nome: ");
	String nome = entrada.nextLine();			//Inserir dado String via teclado na pr�xima linha
												//Dado inserido
	System.out.println("\n\nNome: " + nome);	//Mostrar dado inserido
	
	System.out.print("Digite o seu sobrenome: ");
	String sobrenome = entrada.nextLine();
	
	System.out.print("Digite a sua idade: ");
	int idade = entrada.nextInt();				//Inserir dado int via teclado na pr�xima linha, observe que agora o m�todo usado � nextInt para inserir um dado int
	
	System.out.printf("%s %s tem %d anos.",
			nome, sobrenome, idade);
	
	entrada.close();							//Fechar Scanner
	
	
	
}

}

