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
		/*A diferen�a do map() para andThen(), � que o map serve
		 * para fazer procedimentos em cima de uma lista, andThen
		 * � usado sobre fun��es lambdas, no caso abaixo, esses filtros
		 *est�o sendo feitos em cima de uma lista, sendo que essa n�o
		 *tem esse m�todo andThen(). O map() aparentemente s� aceita
		 *como par�metro fun��es lambdas */
		marcas.stream().map(maiuscula).map(inicial).map(grito).forEach(print);
		
	}
}
