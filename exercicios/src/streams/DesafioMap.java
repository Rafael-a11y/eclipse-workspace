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
	/*O segundo par�metro de parseInt(), serve para indicar de qual
	 * sistema num�rico quero converter para inteiro, ou seja, o 2
	 * significa que eu quero converter de bin�rio para inteiro,
	 * logo ele vai ler como n�mero bin�rio e converter no n�mero
	 * inteiro equivalente*/
	Function <String,Integer> reversao = n -> Integer.
			parseInt(n,2);
	/*Pelo que eu percebi, esses m�todos da classe Stream() s�
	 * retornam os dados processados, mas a stream original continua
	 * intacta*/
//	nums.stream().map(n -> Integer.toBinaryString(n)).
//	map(reverses).map(reversao).forEach(print);
	// o map() tamb�m aceita fun��es est�ticas por reference method
	//como par�metro.
	nums.stream().map(Integer::toBinaryString).map(reverses).
	map(reversao).
	forEach(print);
	System.out.println("\nOriginal\n");
	nums.stream().forEach(print);
	}
}
