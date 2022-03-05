package fundamentos;

public class ConversaoNumeroString {
	
	public static void main(String[] args) {
		
		Integer num1 = 10000;
		String num2 = num1.toString();
		System.out.println(num2.length());
		
		Integer num5 = 10000;
		int num3 = 10000;
		String num4 = Integer.toString(num3);
		
		String valor5 = num5.toString();
		System.out.println(("" + num1).length());
		System.out.println((num3 + "").length());
		
		/*
		 * Neste exerc�cio, eu fiz 3 convers�es de tipo n�m�rico para
		 * o wrapper String.
		 * Na linha 8, usei a nota��o .toString() e .length() para converter
		 * e e mostrar sucetivamente a quantidade de algarismos que formam o
		 * n�mero associado � vari�vel.
		 * Na linha 11, como a vari�vel num2 � do tipo int, tive que chamar e converter
		 * indiretamente para Integer, usando a nota��o Integer.toString(num2) e em se-
		 * guida .length para mostrar de quantos algarismos � formado tal valor.
		 * Nas linhas 13 e 14, usei do artif�cio de concatenar as vari�veis com um va-
		 * lor String para transformar o valor das vari�veis num1 e num2 em String. 
		 */
	}

}
