package br.com.abc.javacore.Sstrings.test;

public class StringTest {

	public static void main(String[] args) {
		
		String nome = "William";
		nome = nome.concat(" Suane"); // é o memso que: nome += " Suane";
		String nome2 = "William";
		/*Uma variável de referência, um objeto e uma String no pool de String */
		String nome3 = new String("Catarina");
		
		String teste = "Goku";
		String teste2 = "     0123456789     ";
		System.out.println(teste.charAt(0));
		System.out.println(teste.equalsIgnoreCase(teste2));
		System.out.println(teste.length());
		System.out.println(teste2.replace('a', 'o'));
		System.out.println(teste2.toLowerCase());
		System.out.println(teste2.toUpperCase());
		System.out.println(teste2.substring(0, 1));
		System.out.println(teste2.trim());
	}

}
