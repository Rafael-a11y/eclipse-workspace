package br.com.abc.javacore.rWrappers.test;

public class WrappersTest {

	public static void main(String[] args) {
		double valor = 100;
		Byte byteWrapper;
		Short shortWrapper;
		Integer integerWrapper = 10;
		Long longWrapper = 10L;
		Float floatWrapper = 10.00F;
		Double doubleWrapper = 50.00;
		Character characterWrapper;
		Boolean booleanWrapper = true;
		char v = '9';
	
		double valorTeste = Double.valueOf(10.00).compareTo(100.00);
		System.out.println(valorTeste);
		
		System.out.println(Character.isDigit(v));
		System.out.println(Character.isLetter('a'));
		System.out.println(Character.isLetterOrDigit('2'));
		System.out.println(Character.isAlphabetic('A'));
		System.out.println(Character.isUpperCase('A'));
		System.out.println(Character.isLowerCase('c'));
		System.out.println(Character.toUpperCase('b'));
	}
			
	}

