package br.com.abc.javacore.ZZLstreamsparalelos;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParalelos1 {
	public static void main(String[] args) {
		long num = 10_000_000_000L;
		somaFor(num);
//		O for() é muito rápido por trabalhar em baixo nível, ou seja, nem sempre é bom usar streams
//		somaStreamIterate(num);
//		somaParallelStreamIterate(num);
//		Para pegar o número de preocessadores presente na máquina, basta chamar a classe Runtime, seguido método estático
//		getRuntime() que reto rna um Runtime, seguido do método de instância availableProcessors() que retorna um int representando
//		o número de núcleos presentes neste PC.
		System.out.println("Número de processadores presente neste PC: " + Runtime.getRuntime().availableProcessors());
//		O método estático da classe System, o setProperty(), serve para que o programador possa definir o número de threads
//		que serão usadas, mas tome cuidado, mais threads não significa um algorítmno mais rápido! Além de que essa configuração
//		 é global, ou seja, essa mudança no número de threads vale para todos os outros programas. Os parâmetros deste método
//		são uma String key, e uma String value.
//		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
		somaRangeClosedStream(num);
//		Até agora, o forEach tradicional continua invencível, inclusive ganha do rangeClosed com paralelismo, ou seja, uso de thread
//		não necessariamente significa um cóidigo mais rápido, mas com um valor absurdo como o 10000000000, o LongStream com 
//		paralelismo (somaRangeClosedParallelStream) ganha de lavada, de 8 segundos e 90 milisegundos contra os 9 segundos e
//		177 milisegundos do forEach tradicional..
		somaRangeClosedParallelStream(num );
	}
	private static void somaFor(long num) {
		System.out.println("For");
		long result = 0;
		long init = System.currentTimeMillis();
		for(long i = 0; i <= num; i++) {
			result += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
	private static void somaStreamIterate(long num) {
		System.out.println("Soma Stream Iterate");
		long result = 0;
		long init = System.currentTimeMillis();
//		O iterate gera stream de números indefinidamente, por isso a necessidade de usar o limit(), seu parâmetros são: um número
//		de início, e uma lambda onde a lógica de Fibonnati é implementada, onde o número gerado é o resultado da equação de soma
//		do número anterior somado com 1. E o por fim, o reduce() que tem 0 como acumulador inicial e um BinaryOperator, onde o 0
//		é somado com o primeiro elemento da stream (essa stream é de números), e o resultado desta equação é a nova identidade
//		numérica a ser somada com o proximo elemento numérico da stream.
		result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	Você deve estar se perguntado: Será que agora eu melhoro a performance do processamneto com uso de mais de uma thread?
//	E a resposta é não, cada elemento sofre alterações de boxing e unboxing, o que leva bastante tempo e custo de 
//	processamento, por enquanto o Parallel Stream continua invencível. Você pode alternar entre o paralelismo e sequencialismo
//	 com os método sequential() e parallel().
	private static void somaParallelStreamIterate(long num) {
		System.out.println("Soma Parallel Stream Iterate");
		long result = 0;
		long init = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	Com a Interface LongStream, o processamento de boxing e unboxing não ocorre, o processador irá trabalhar com tipos primitivos,
//	além que, os números serão gerados em tempo de execução, ou seja, não haverá uma iteração. Será que eu poderia fornecer
//	Uma lambda cujo método tivesse um único parâmetro? Será que eu poderia fornecer até 3 parâmetros para esta lambda, desde
//	que o método usado aceite mais parâmetros? Lembrando que a regra de usar refrence method, é quando a lambda é simples, isso
//	 é, quando dentro da lambda, apenas um método é chamado, idependente do número de parâmetros. Creio que o método usado dentro
//	da lambda, precisa apenas pertencer à instância ou classe a qual os elementos da stream pertencem.
	private static void somaRangeClosedStream(long num) {
		System.out.println("Range Closed Stream Usando LongStream");
		long result = 0;
		long init = System.currentTimeMillis();
		result = LongStream.rangeClosed(1L, num).reduce(0L, (num1, num2) -> Long.sum(num1, num2));
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	Agora vamso usar o rangeClosed() da interface LongStream, do pacote stream, só que com a pequena diferença, que é o paralelismo,
//	sim, uma stream paralela.
	private static void somaRangeClosedParallelStream(long num) {
		System.out.println("Range Closed Parallel Stream Usando LongStream");
		long result = 0;
		long init = System.currentTimeMillis();
		result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, (num1, num2) -> Long.sum(num1, num2));
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	CONCLUSÕES: faça benchMark (medidas de performance), streams paralelos nem sempre são mais rápidos que os sequenciais,
//	as vezes é melhor usar streams sequenciais, é bom também ficar atento se os streams que você está a usar fazem uso de 
//	boxing e unboxing, esses recursos custam muito processamento e performance. Outro ponto é que: algumas operações são menos
//	eficientes quando paralelas do que em sequenciais, exemplo são liomit() e findFirst(), são bem melhores questão de performance
//	quando usadas sequencialmentes do que em pareaelelo, pois necessitam que os elementos estejam ordenados, agora, o findSAny()
//	é bem mais eficiente quando usado em modo paralelo, pois não necessita que ops elementos estejam ordenados, e você pode
//	chamar streams desordenadas usando unordened(). Outra questão a se considerar é custo total de processamento, e o número de
//	elementos, se o coeficiente de performance for alto, geralmente é uma boa usar streams paralelas. Outro fator importante a ser considerado,
//	é a quantidade de dados, se for pequena, quase nunca usar streams paralelas será a decisão certa, para estes casos, usar
//	streams seuqencialmente é a melhor opção, outra coisa a lembrar é o tipo de coleção a ser usada com streams, o ASrrayList
//	por exemplo, é muito melhor que o LinkedList para se usar em streams paralelas, pois, no LinkedList, você precis ficar
//	percorrendo a lista toda, coleções de tamanho definido são bem melhores de se dividir em threads de stream paralelas, 
//	também é bom se atentar à isso.Uma stream paralela funciona assim:
/*	if(tarefa é pequena ou não pode ser dividida){
 		faça sequencialmente;
 	}
 	else{
 		dividir em duas tarefas;
 		chamar o método recursivamente;
 		esperar todas as tarefas serem completadas;
 		combinar todos os resultados;
 		processamento do merge;
 	}*/
}
