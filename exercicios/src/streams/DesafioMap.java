package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Consumer<Object> print = System.out::println;
	
	Function<String, String> reverses = ss-> new StringBuilder(ss)
			. reverse(). toString();
	/*O segundo parâmetro de parseInt(), serve para indicar de qual
	 * sistema numérico quero converter para inteiro, ou seja, o 2
	 * significa que eu quero converter de binário para inteiro,
	 * logo ele vai ler como número binário e converter no número
	 * inteiro equivalente*/
	Function <String,Integer> reversao = n -> Integer.
			parseInt(n,2);
	/*Pelo que eu percebi, esses métodos da classe Stream() só
	 * retornam os dados processados, mas a stream original continua
	 * intacta*/
//	nums.stream().map(n -> Integer.toBinaryString(n)).
//	map(reverses).map(reversao).forEach(print);
	// o map() também aceita funções estáticas por reference method
	//como parâmetro.
	nums.stream().map(Integer::toBinaryString).map(reverses).
	map(reversao).
	forEach(print);
	System.out.println("\nOriginal\n");
	nums.stream().forEach(print);
	}
}
