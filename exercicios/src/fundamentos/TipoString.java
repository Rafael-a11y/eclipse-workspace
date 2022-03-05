package fundamentos;

public class TipoString {
public static void main(String[] args) {
	System.out.println("Olá pessoal".charAt(2));
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
			sobrenome + "\nIdade: " + idade + "\nSalário:" + salario + "\n\n" ;
	System.out.println(maisUmaFrase);
	
	//e também
	
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
	 * Dentro da instância de saída, não é preciso atribuir a 
	 * funcionalidade de concatenação a "Boa tarde", já que este 
	 * valor não foi atribuído a uma variável.
	 * No System.out.printf:
	 * %s substitui valores String, %d substitui valores inteiros,
	 * %f substitui valores reais float e double, enquanto que
	 * .2 de %.2f pede para mostrar apenas 2 casas decimais
	 *	O \n serve para quebra de linha.
	 *	String frase recebe String.format na linha 27 e é imprimido
	 *na linha 29.
	 *	Tanto o System.out.printf e String.format servem para substituir
	 *variáveis por pequenos comandos como %s. A diferença é que no 
	 *exemplo acima, o String.format é executado em uma variável
 *tipo String.
 *		A notação .contains(CharSequence s) verifica se a String se encontra
 *na frase.
 *		A notação .indexOf(String str) verifica o índice da String
 *especificada(começando pelo 0).
 *		A notação .subString(int beginIndex, int endIndex) serve para
 *que, selecionando dois números inteiros, seja determinada um 
 *parâmetro de início e fim da String, lembrando que o 1° parâmetro 
 *é inclusivo e o 2° parâmetro exclusivo.
	 */
}
}
