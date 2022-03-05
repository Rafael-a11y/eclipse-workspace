package fundamentos;

import java.util.Scanner;

public class ConsoleRafael {
public static void main(String[] args){
	String nome = "Rafael"; 
	int idade = 20;
	String sobrenome = "Souto";
	System.out.printf("A idade é de %d anos, pertencente a %s %s%n", idade,
			 nome, sobrenome);
	
	
	Scanner entradaExemplo = new Scanner (System.in); //escanear a entrada
	
	
	System.out.print("Digite seu nome: ");
	String nomeDois = entradaExemplo.nextLine();
	entradaExemplo.close();
	
	
}
}
