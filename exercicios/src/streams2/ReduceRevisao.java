package streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceRevisao {
	
	public static void main(String[] args) {
		
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4,
				5, 6);
		List<String> palavras = Arrays.asList("Olá_", "senhor_",
				"Rafael.");
		BinaryOperator<Integer> soma = (n1, n2) -> n1 + n2;
		BinaryOperator<Integer> multiplicacao = (n1, n2) -> n1 * n2;
		System.out.println(numeros.stream().
				reduce(0, soma));
		System.out.println(palavras.parallelStream().
				reduce((s1, s2) -> s1.concat(s2)));
	}

}
