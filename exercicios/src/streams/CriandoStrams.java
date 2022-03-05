package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStrams {
	public static void main(String[] args) {
		int escolha = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escolha o índice de início da lista: ");
		escolha = entrada.nextInt();
		Consumer<String> print = System.out :: print;
		Consumer<Integer> println = System.out::println;
		Stream<String> linguagens = Stream.of("Java ","Lua ","Java/S\n");
		linguagens.forEach(print);
		
		String[] maisLinguagens = {"Python ","Lisp ","Perl ","Go\n"};
		Stream.of(maisLinguagens).forEach(print);
		Arrays.stream(maisLinguagens).forEach(print);
		Arrays.stream(maisLinguagens, escolha, 4).forEach(System.out::print);
		List<String> outrasLinguagens = Arrays.asList("C++ ","PHP ","Kotlin\n" );
		outrasLinguagens.stream().forEach(print);
		outrasLinguagens.parallelStream().forEach(print);
		//Stream.generate(() -> "a").forEach(print);
		//Stream.iterate(0,n -> n + 1).forEach(println);
		entrada.close();
	}
}
