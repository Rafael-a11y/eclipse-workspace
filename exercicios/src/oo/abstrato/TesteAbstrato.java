package oo.abstrato;

import java.util.Scanner;

public class TesteAbstrato {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String escrever = "";
		System.out.println("Entre com os dados: ");
		escrever = entrada.next();
		System.out.println(escrever);
		Mamifero a = new Cachorro();
		
		System.out.println(a.respirar());
		System.out.println(a.mover());
		System.out.println(a.mamar());
	}

}
