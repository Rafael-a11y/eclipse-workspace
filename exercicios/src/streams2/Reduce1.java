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
		//Reduce é um método terminador, e não necessariamente
		//gerar um valor, para isso usamos o get()
		System.out.println(numeros.stream().reduce(soma));
		//ou
		System.out.println(numeros.stream().reduce(soma).get());
		//ou
		Integer total = numeros.stream().reduce(soma).get();
		System.out.println(total);
		//Já não é mais um Optional, pois mesmo que a stream seja
		//vazia, ainda há o retorno do número 100, sendo assim
		// o get() já não pode ser usado.
		int total2 = numeros.stream().reduce(100, soma);
		System.out.println(total2);
		/*O reduce usado abaixo, é o que espera apenas uma função
		lambda acumuladora, do tipo Optional, sendo assim, a partir
		dela é possível acessar a classe Optional e usar o ifPresent().
		Mas é bom resaltar que existem 3 reduces na classe Stream*/
		numeros.stream().
		filter(n -> n > 10).reduce(soma)
		.ifPresent(System.out::println);
	}
}
