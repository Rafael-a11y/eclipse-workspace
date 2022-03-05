package streams;

import java.util.ArrayList;
import java.util.List;

public class Teste2 {
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(5);
		numeros.add(6);
		numeros.add(7);
		numeros.add(8);
		numeros.stream().forEach(System.out::println);
	}
}
