package lambdas;

import java.util.function.Function;

public class Funcao {
	public static void main(String[] args) {
		/*A interface Function, recebe um argumento e retorna um resultado, o diferencial
		 * desta fun��o � que voc� pode definir o tipo do Par�metro e o tipo de retorno a ser 
		 * retornado*/
		Function<Integer, String> parOuImpar = numero -> numero % 2 == 0 ? "Par" : "�mpar";
		
		/*Apply aplica esta fun��o(no caso, parOuImpar) ao argumento fornecido, retorna o re
		 * sultado da fun��o*/
		System.out.println("O n�mero �: " + parOuImpar.apply(32));
		
		Function<String, String> oResultadoE = valor -> "O resultado � " + valor;
		
		Function<String, String> empolgado = valor -> valor + "!!!";
		Function<String, String> duvida = valor -> valor + "???";
		
		/*andThen retorna uma fun��o composta que primeiro aplica esta fun��o a sua entrada e,
		 em seguida, aplica a fun��o posterior ao resultado. Se a avalia��o de qualquer uma
		 das fun��es lan�ar uma exce��o, ela ser� retransmitida ao chamador da fun��o
		  composta. De uma maneira mais simples de entender: andThen recebe como par�metro
		  o m�todo oResultadoE, que ter� como par�metro, o resultado do m�todo parOuImpar,
		  andThen primeiro executar�a parOuImpar e depois executar� oResultadoE (que � o pa
		  r�metro de andThen). */
		String resultadoFinal1 = parOuImpar.andThen(empolgado).andThen(oResultadoE).apply(32);
		System.out.println(resultadoFinal1);
		/*apply deve estar no final da linha para que a cadeia de fun��es seja executada,
		 * come�ando por aplicar um valor Integer 32 � fun��o parOuImpar, que a partir disso,
		 * ter� seu resultado como par�metro da fun��o posterior e assim por diante. Isso �
		 * o que chamamos de composi��o de fun��es, onde fun��es que s�o respons�veis por
		 * fazer pequenos processamentos, por�m, s�o concatenadas uma a outra, compondo
		 * um processamento mais complexo!*/
		String resultadoFinal2 = parOuImpar.andThen(oResultadoE).andThen(duvida).apply(32);
		System.out.println(resultadoFinal2);
		/*Qanto maior uma fun��o, mais dif�cil ser� de reutiliza-la em outras partes do
		 * sistema, pois uma fun��o grande, � muito espec�fica, diferentemente de fun��es
		 * menore, que possuem menos responsabilidades e, portanto, s�o mais gen�ricas*/
		
	}

}
