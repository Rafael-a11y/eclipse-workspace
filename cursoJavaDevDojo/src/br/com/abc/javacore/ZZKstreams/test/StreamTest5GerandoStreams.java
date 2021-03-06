package br.com.abc.javacore.ZZKstreams.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5GerandoStreams {

	public static void main(String[] args) {
//		A diferen?a de range() para rangeClosed() ? que o primeiro possui um n?mero de limite exclusivo, no segundo, o n?mero
//		de ?ndice final ? inclusivo.
		 IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0).forEach(p -> System.out.print( p + " "));
		 System.out.println();
		 IntStream.range(1, 10).filter(n -> n % 2 == 0).forEach(p -> System.out.print( p + " "));
		 
//		 Para criarmos uma stream<String>, podemos chamar o m?todo est?tico of(), que retorna uma stream ordenada sequencial
//		 cujos elementos s?o os valores especificados, no caso do exemplo mostrado, usamos apenas 3 Strings. Usamos um map()
//		 para deixar a caixa de toda a stream gerada em caixa alta e depois usamos o forEach() para imprimir o valores com o
//		 m?todo print().
		 Stream<String> stringStream = Stream.of("William", "DevDojo", "Acessem o facebook pelo amor de deus e curtam valeu");
		 System.out.println();
		 stringStream.map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
		 
//		 Para o caso de voc? querer criar uma Stream vazia, use Object como tipo, depois chame o m?todo est?tico empty(). Lembrando
//		 que usar o tipo Object n?o ? obrigat?rio, ? s? para exemplificar.
//		 Criamos uma stream de inteiros a ?partir de um array de inteiros primitivos, a partir do m?todo est?tico da classe
//		 Arrays que retorna um IntStream do pacote stream, que ? um tipo de Stream que trabalha com tipos primitivos. Mas
//		 o que queremos aqui no caso n?o ? chamar o map(), ou um filter(), o objetivo aqui ? conseguir a m?dia, por isso
//		 chamamos o average(), que por sua vez retorna um OptionalDouble, que ? um Optional especializado em tipo primitivo
//		 Double. E por fim, como sabemos, em um Optional, o valor pode ou n?o estar presente, por este motivo, chamamos o m?todo
//		 de inst?ncia getAsDouble(), que retorna o n?mero caso este exista, caso contr?rio, lan?a um NoSuchElementException.
		 Stream<String> empty = Stream.empty();
		 int[] nums = {1, 2, 3, 4, 5};
		 OptionalDouble average = Arrays.stream(nums).average();
		 System.out.println("\n" + average.getAsDouble());
		 
//		 Usamos o try with resources para que o arquivo seja fechado automaticamente, pois bem, usamos uma vari?vel de refer?ncia
//		 do tipo Stream<String> que aponta para o m?todo est?tico da classe Files, o lines() que l? as linhas de um arquivo,
//		 como este m?todo espera um Path de par?metro, usamos o m?todo est?tico get() que captura um arquivo, o m?todo lines()
//		 tamb?m espera o m?todo est?tico da classe abstrata Charset. Usamos em seguida um flatmap() para alcan?ar os valores
//		 mais internos que s?o as Strings no arquivo de tetxto, usamos o split("\n") com uma String "\n" dentro para o split()
//		 quebrar o texto do arquivo em v?rias Strings, ou seja, a cada quebra de linha, o texto ? dividido em 2 Strings, depois
//		 usamos um filter() para filtrar as Strings, usando o contains() para saber se possuem a substring "File" seguido de
//		 um forEach() para imprimi-las.
		 try(Stream<String> lines = Files.lines(Paths.get("arquivo_renomeado.txt"), Charset.defaultCharset())){
			 lines.flatMap(line -> Arrays.stream(line.split("\n")))
			 .filter(p -> p.contains("File"))
			 .forEach(System.out::println);
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
//		 Gerando stream de valores infinitos, chamamos o iterate(), m?todo est?tico da classe stream, onde fornecemos um valor
//		 seed e uma fun??o UnaryOperator, onde n inicialmente ? 1 e ? somado com 2, que d?, logo n passa a valer 3 que ? somado
//		 com 2, que d? cinco, e assim por diante, limatos a opera??o a 10 somas somente com o m?todo limit().
		 Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);
//		 0,1,1,2,3,5,8,13,21,34,55...
//		 (0,1) (1,1) (1,2) (2,3) (3,5) (5,8) (8,13) (13,21) (21,34) (34,55)...
//		 O valor da direita ? a soma dos dois valores anteriores, e o da esquerda ? a repeti??o do valor mais a direita do
//		 par?ntesis anterior. O m?todo iterate esperea um valor semente e uma UnaryOperator, cuja express?o retorna o mesmo
//		 dado de entrada, modificado, claro. Sendo assim, crio um array de inteiuros com duas posi??es, 0 e 1, cujos valores
//		 s?o 0,1. N a fun??o lambda eu digo que o valor do array na primeira posi??o ? equivalente a segunda posi??o, e que a
//		 segunda posi??o ? o resultado da primeira posi??o somado com o vcalor da segunda posi??o, essa opera??o ? iterada v?rias
//		 vezes, seguido de uma impress?o com um forEach
		 Stream.iterate(new int[] {0,1} , a -> new int[] {a[1], a[0] + a[1]})
		 .limit(5)
		 .forEach(t -> System.out.println(Arrays.toString(t)));
		 
		 Stream.iterate(new int[] {0,1} , a -> new int[] {a[1], a[0] + a[1]})
		 .limit(10)
		 .map(t -> t[0])
		 .forEach(System.out::println);
		 System.out.println();
//		 O generate() espera de par?metro um lambda Supplier, usamos um reference method a um m?todo est?tico concreto de uma
//		 classe concreta, isso ? poss?vel pois o functional Descriptor ? totalmente compat?vel a uma fun??o Supplier, algo
//		 que n?o recebe nada de par?metro e retorna algum valor, usamos o limit() para limitar a 10 itera??es e valores gerados,
//		  seguido de um forEach()
		 Stream.generate(Math::random).limit(10).forEach(System.out::println);
		 
//		 O m?todo est?tico current() cria e retorna o objeto ThreaadLocalRandom, usamos uma lambda Supplier de par?metro para
//		 o generate() onde o objeto ThreadLocalRandom chama o m?todo nextInt(), respons?vel por criar valores inteiros dentro
//		 de um intervalo de valores, intervalo esse fornecido de par?metro do m?todo, sendo o primeiro n?mero de ?ndice inclusivo
//		 e o ?ltimo de?ndice exclusivo, seguido de um limit(100) para limitar a 100 valores gerados de 1 a 99, e em seguida
//		 um forEach para imprimir.
 		 ThreadLocalRandom t = ThreadLocalRandom.current();
		 Stream.generate(() -> t.nextInt(1,100)).limit(100).forEach(System.out::println);
	}	

}
