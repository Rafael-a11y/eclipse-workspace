package fundamentos;

import java.util.Scanner;

public class TestandoString {
	public static void main(String[] args) {
		
		String nome; 
		Scanner entrada = new Scanner(System.in);
		System.out.print("Entre com o nome completo: ");
		nome = entrada.next();
		System.out.println(nome);
		entrada.close();
	}
}
