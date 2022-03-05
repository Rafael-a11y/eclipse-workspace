package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Teste {
	public static void main(String[] args) {
		Consumer<String> print = System.out::print;
		List<String> marcas = Arrays.asList("BMW ","Audi ","Honda");
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		UnaryOperator<String> inicial = n -> n.charAt(0) + "";
		UnaryOperator<String> grito = n -> n + "!!!";
		System.out.println("\n#Testando\n");
		/*A diferença do map() para andThen(), é que o map serve
		 * para fazer procedimentos em cima de uma lista, andThen
		 * é usado sobre funções lambdas, no caso abaixo, esses filtros
		 *estão sendo feitos em cima de uma lista, sendo que essa não
		 *tem esse método andThen(). O map() aparentemente só aceita
		 *como parâmetro funções lambdas */
		marcas.stream().map(maiuscula).map(inicial).map(grito).forEach(print);
		
	}
}
