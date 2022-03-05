package streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {
	
	public static void main(String[] args) {
		
		Consumer<Object> imprimir = System.out::println; 
		//Criando Streams a partir  da Interface Stream
		Stream<String> linguagens = Stream.of("Java", "Lua", "JS\n");
		linguagens.forEach(imprimir);
		//Crinado Stream a partir de array
		String[] maisLinguagens = {"Python", "Lisp", "Perl", "Go\n"};
		Stream.of(maisLinguagens).forEach(imprimir);
		//Criando Streams a partir da Classe Array, lista fixa
		Arrays.stream(maisLinguagens).forEach(imprimir);
		Arrays.stream(maisLinguagens, 1, 4).forEach(imprimir);
		//Criando Stream a partir de uma lista
		List<String> outrasLinguagens = Arrays	.asList("C", "PHP", "Kotlin");
		outrasLinguagens.parallelStream().forEach(imprimir);
//		Stream.iterate(0, (n) -> n + 1).forEach(imprimir);
	}

}
