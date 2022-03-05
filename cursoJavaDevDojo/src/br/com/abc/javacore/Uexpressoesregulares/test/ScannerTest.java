package br.com.abc.javacore.Uexpressoesregulares.test;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner("1 true 100 oi");
		while(entrada.hasNext()) {
			System.out.println(entrada.next());
		}
		System.out.println("####################################");
		Scanner entrada2 = new Scanner("1 true 100 oi");
		 while(entrada2.hasNext()) {
			 if(entrada2.hasNextInt()) {
				 int i = entrada2.nextInt();
				 System.out.println("int " + i);
			 }
			 else if(entrada2.hasNextBoolean()) {
				 boolean b = entrada2.nextBoolean();
				 System.out.println("boolean " + b);
			 }
			 else {
				 System.out.println(entrada2.next());
			 }
			 
		 }
	}

}
