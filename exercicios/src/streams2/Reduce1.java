package streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5,
				6, 7, 8,9);
		BinaryOperator<Integer> soma = (acumulador, numero) -> 
		acumulador + numero;
		//Reduce � um m�todo terminador, e n�o necessariamente
		//gerar um valor, para isso usamos o get()
		System.out.println(numeros.stream().reduce(soma));
		//ou
		System.out.println(numeros.stream().reduce(soma).get());
		//ou
		Integer total = numeros.stream().reduce(soma).get();
		System.out.println(total);
		//J� n�o � mais um Optional, pois mesmo que a stream seja
		//vazia, ainda h� o retorno do n�mero 100, sendo assim
		// o get() j� n�o pode ser usado.
		int total2 = numeros.stream().reduce(100, soma);
		System.out.println(total2);
		/*O reduce usado abaixo, � o que espera apenas uma fun��o
		lambda acumuladora, do tipo Optional, sendo assim, a partir
		dela � poss�vel acessar a classe Optional e usar o ifPresent().
		Mas � bom resaltar que existem 3 reduces na classe Stream*/
		numeros.stream().
		filter(n -> n > 10).reduce(soma)
		.ifPresent(System.out::println);
	}
}
