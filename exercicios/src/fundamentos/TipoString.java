package fundamentos;

public class TipoString {
public static void main(String[] args) {
	System.out.println("Ol� pessoal".charAt(2));
	String s = "Boa tarde";
	System.out.println(s.concat("!!!"));
	System.out.println(s + "!!!");
	System.out.println(s.startsWith("Boa"));
	System.out.println(s.toLowerCase().startsWith("boa"));
	System.out.println(s.toUpperCase().endsWith("TARDE"));
	System.out.println(s.length());
	System.out.println(s.toLowerCase().equals("boa tarde"));
	System.out.println(s.equalsIgnoreCase("boa tarde"));
	
	var nome = "Pedro";
	var sobrenome = "Santos";
	var idade = 33;
	var salario = 12345.987;
	
	String maisUmaFrase = "Nome: " + nome + "\nSobrenome: " +
			sobrenome + "\nIdade: " + idade + "\nSal�rio:" + salario + "\n\n" ;
	System.out.println(maisUmaFrase);
	
	//e tamb�m
	
	System.out.printf("O Senhor  %s %s tem %d e ganha R$%.2f", nome,
			sobrenome, idade, salario);
	
	//OU
	
	
	String frase = String.format("\nO Senhor  %s %s tem %d e ganha R$%.2f", nome,
			sobrenome, idade, salario);
	System.out.println(frase);
	
	System.out.println("Frase qualqer".contains("qual"));
	System.out.println("Frase qualquer".indexOf("qual"));
	System.out.println("Frase qualquer".substring(6,10));
	/*
	 * Dentro da inst�ncia de sa�da, n�o � preciso atribuir a 
	 * funcionalidade de concatena��o a "Boa tarde", j� que este 
	 * valor n�o foi atribu�do a uma vari�vel.
	 * No System.out.printf:
	 * %s substitui valores String, %d substitui valores inteiros,
	 * %f substitui valores reais float e double, enquanto que
	 * .2 de %.2f pede para mostrar apenas 2 casas decimais
	 *	O \n serve para quebra de linha.
	 *	String frase recebe String.format na linha 27 e � imprimido
	 *na linha 29.
	 *	Tanto o System.out.printf e String.format servem para substituir
	 *vari�veis por pequenos comandos como %s. A diferen�a � que no 
	 *exemplo acima, o String.format � executado em uma vari�vel
 *tipo String.
 *		A nota��o .contains(CharSequence s) verifica se a String se encontra
 *na frase.
 *		A nota��o .indexOf(String str) verifica o �ndice da String
 *especificada(come�ando pelo 0).
 *		A nota��o .subString(int beginIndex, int endIndex) serve para
 *que, selecionando dois n�meros inteiros, seja determinada um 
 *par�metro de in�cio e fim da String, lembrando que o 1� par�metro 
 *� inclusivo e o 2� par�metro exclusivo.
	 */
}
}
