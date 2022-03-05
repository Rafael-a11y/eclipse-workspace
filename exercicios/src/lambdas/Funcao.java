package lambdas;

import java.util.function.Function;

public class Funcao {
	public static void main(String[] args) {
		/*A interface Function, recebe um argumento e retorna um resultado, o diferencial
		 * desta função é que você pode definir o tipo do Parâmetro e o tipo de retorno a ser 
		 * retornado*/
		Function<Integer, String> parOuImpar = numero -> numero % 2 == 0 ? "Par" : "Ímpar";
		
		/*Apply aplica esta função(no caso, parOuImpar) ao argumento fornecido, retorna o re
		 * sultado da função*/
		System.out.println("O número é: " + parOuImpar.apply(32));
		
		Function<String, String> oResultadoE = valor -> "O resultado é " + valor;
		
		Function<String, String> empolgado = valor -> valor + "!!!";
		Function<String, String> duvida = valor -> valor + "???";
		
		/*andThen retorna uma função composta que primeiro aplica esta função a sua entrada e,
		 em seguida, aplica a função posterior ao resultado. Se a avaliação de qualquer uma
		 das funções lançar uma exceção, ela será retransmitida ao chamador da função
		  composta. De uma maneira mais simples de entender: andThen recebe como parâmetro
		  o método oResultadoE, que terá como parâmetro, o resultado do método parOuImpar,
		  andThen primeiro executaráa parOuImpar e depois executará oResultadoE (que é o pa
		  râmetro de andThen). */
		String resultadoFinal1 = parOuImpar.andThen(empolgado).andThen(oResultadoE).apply(32);
		System.out.println(resultadoFinal1);
		/*apply deve estar no final da linha para que a cadeia de funções seja executada,
		 * começando por aplicar um valor Integer 32 á função parOuImpar, que a partir disso,
		 * terá seu resultado como parâmetro da função posterior e assim por diante. Isso é
		 * o que chamamos de composição de funções, onde funções que são responsáveis por
		 * fazer pequenos processamentos, porém, são concatenadas uma a outra, compondo
		 * um processamento mais complexo!*/
		String resultadoFinal2 = parOuImpar.andThen(oResultadoE).andThen(duvida).apply(32);
		System.out.println(resultadoFinal2);
		/*Qanto maior uma função, mais difícil será de reutiliza-la em outras partes do
		 * sistema, pois uma função grande, é muito específica, diferentemente de funções
		 * menore, que possuem menos responsabilidades e, portanto, são mais genéricas*/
		
	}

}
