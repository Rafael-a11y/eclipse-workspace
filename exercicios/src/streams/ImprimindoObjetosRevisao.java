package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ImprimindoObjetosRevisao {
	public static void main(String[] args) {
		List<String> aprovados = Arrays.asList("Lu","Gui","Luca","Ana");
		System.out.println("#01 Usando um for e o método get()");
		for (int i = 0; i < aprovados.size(); i++) {
			System.out.println(aprovados.get(i));
		}
		System.out.println("#02 Usando um forEach tradicional");
		for (String aprovado : aprovados) {
			System.out.println(aprovado);
		}
		//Consegue-se usar Iterator a partir de uma lista.
		/*hasNext() retorna valor boolean se houver um próximo elemento
		 * na lista. Já o next() avança para o próximo elemento*/
		System.out.println("#03 Usando o Iterator");
		Iterator<String> iterator = aprovados.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("#04 Usando a Interface Stream");
		Stream<String> stream = aprovados.stream();
		stream.forEach(System.out::println);
		
	}
}
