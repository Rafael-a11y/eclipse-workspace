package br.com.abc.javacore.ZZMcompletablefuture.test;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.abc.javacore.ZZMcompletablefuture.classes.Loja;

public class LojaTest2 {
	//Nesta aula, n�s iremos aprender a criar um c�digo sem bloqueiio, non-blocking.
	public static void main(String[] args) {
		List<Loja> lojas = asList(new Loja("Americanas"),
				new Loja("Casas Bahia"),
				new Loja("Best Buy"),
				new Loja("Casas Bahia"),
				new Loja("Best Buy"),
				new Loja("Casas Bahia"),
				new Loja("Best Buy"),
				new Loja("Casas Bahia"),
				new Loja("Best Buy"),
				new Loja("Casas Bahia"),
				new Loja("Best Buy"),
				new Loja("Casas Bahia"),
				new Loja("Best Buy"),
				new Loja("Wallmart"));
		
//		acharPrecos(lojas);
		//Usando Streams Prallelos, cada linha de execu��o acontece paralelamente em processadores diferentes, como meu PC
		//possui 4, cada objeto loja foi processado em CPU's diferentes.
		acharPrecos2(lojas);
		//CompletableFuture � quase t�o demorado quanto de forma sequencial, pois o CompletableFuture, processa os objetos
		//Loja um a um, e depois, sai juntando de um em um, ou seja de forma sequencial, mas um pouco mais r�pida.
//		acharPrecos3(lojas);
		acharPrecos4(lojas);
	}
	//Situa��o problema: criar um m�todo cujo retorno � uma List<String> e voc� n�o pode chamar os m�todos getPrecoAsync() ou
	//getPrecoAsyncTunado(), apenas o mais simples, getPreco(), que gera um valor double rand�nicamente e o devolve.
	private static List<String> acharPrecos(List<Loja> lojas){
		System.out.println("Stream Sequencial");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.stream().map(loja -> String.format("%s o pre�o � %.2f", loja.getNome(), loja.getPreco()))
		.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println(collect);
		return collect;
	}
	//Agora vamos tentar rerduzir este tempo de processamento.
	private static List<String> acharPrecos2(List<Loja> lojas){
		System.out.println("Stream Parallelo");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.stream().map(loja -> String.format("%s o pre�o � %.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println(collect);
		return collect;
	}
	//Agora vamos fazer uma chamada usando CompletableFuture! Com o join(), voc� n�o precisa tratar as exce��es, e pertence
	//ao CompletableFuture, e n�o ao Future. Como o join() j� faz a invo��o e extra��o do valor contido no CompletableFuture,
	//tomei a liberdade de remover a linha que marca o tempo de invoca��o.
	private static List<String> acharPrecos3(List<Loja> lojas){
		System.out.println("Completable Future Sequencial");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.stream()
				.map(loja -> CompletableFuture.supplyAsync(
						() -> String.format("%s o pre�o � %.2f", loja.getNome(), loja.getPreco())))
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println(collect);
		return collect;
	}
	//Para resolver o problema do tempo de execu��o, vamos dividir esta Stream em duas. Fazemos isso criando uma lista de
	//CompletableFuture de String, posteriormente aplicamos mais uma sequ�ncia de processamento nesta List de CompletableFuture
	//de Strings.
	private static List<String> acharPrecos4(List<Loja> lojas){
		System.out.println("Completable Future");
		long start = System.currentTimeMillis();
		List<CompletableFuture<String>> precoFuturo = lojas.stream()
				.map(loja -> CompletableFuture.supplyAsync(
						() -> String.format("%s o pre�o � %.2f", loja.getNome(), loja.getPreco())))
				.collect(Collectors.toList());
		//Aqui a gente usa o collect(Collectors.toList()), porque o map() por si s�, retorna uma Stream, Stream essa de Strings,
		//por isso usamos o collect(Collectors.toList()), pois ele remove os elementos desta Stream<String> para uma Lista, j�
		// o join() serve para pegar esses valores de dentro do CompletableFuture<String>, retorna as String's, mas elas s�o
		//encapsuladas dentro de uma Stream, pois m�todos intermedi�rios da API de streams sempre retornam outras Streams.
		//Abaixo voc� confere o como � feito este processamento sem o collect(Collectors.toList()).
//		Stream<String> collect = precoFuturo.stream().map(CompletableFuture::join);
		List<String> collect = precoFuturo.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println(collect);
		return collect;
	}

}