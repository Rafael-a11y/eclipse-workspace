package streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Map {
	public static void main(String[] args) {
		
		Consumer<String> print = System.out::println;
		List<String> marcas = Arrays.asList("BMW", "Audi", "Honda");
		
		//Declarou-se uma Lambda Expression de par�metro no map()
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
		//Precisa usar refence method para poder continuar a
		//concatenar as fun��es.
		System.out.println("Usando Stremas...");
		marcas.stream().map(Utilitarios.maiuscula).
		map(Utilitarios.primeiraLetra).
		//aparentemente, m�todos n�o est�ticos precisam de
		//Reference Method.
		map(Utilitarios::grito).
		forEach(print);
	}
}
