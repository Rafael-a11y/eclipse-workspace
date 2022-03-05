package br.com.abc.javacore.ZZLstreamsparalelos;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsParalelos1 {
	public static void main(String[] args) {
		long num = 10_000_000_000L;
		somaFor(num);
//		O for() � muito r�pido por trabalhar em baixo n�vel, ou seja, nem sempre � bom usar streams
//		somaStreamIterate(num);
//		somaParallelStreamIterate(num);
//		Para pegar o n�mero de preocessadores presente na m�quina, basta chamar a classe Runtime, seguido m�todo est�tico
//		getRuntime() que reto rna um Runtime, seguido do m�todo de inst�ncia availableProcessors() que retorna um int representando
//		o n�mero de n�cleos presentes neste PC.
		System.out.println("N�mero de processadores presente neste PC: " + Runtime.getRuntime().availableProcessors());
//		O m�todo est�tico da classe System, o setProperty(), serve para que o programador possa definir o n�mero de threads
//		que ser�o usadas, mas tome cuidado, mais threads n�o significa um algor�tmno mais r�pido! Al�m de que essa configura��o
//		 � global, ou seja, essa mudan�a no n�mero de threads vale para todos os outros programas. Os par�metros deste m�todo
//		s�o uma String key, e uma String value.
//		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
		somaRangeClosedStream(num);
//		At� agora, o forEach tradicional continua invenc�vel, inclusive ganha do rangeClosed com paralelismo, ou seja, uso de thread
//		n�o necessariamente significa um c�idigo mais r�pido, mas com um valor absurdo como o 10000000000, o LongStream com 
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
//		O iterate gera stream de n�meros indefinidamente, por isso a necessidade de usar o limit(), seu par�metros s�o: um n�mero
//		de in�cio, e uma lambda onde a l�gica de Fibonnati � implementada, onde o n�mero gerado � o resultado da equa��o de soma
//		do n�mero anterior somado com 1. E o por fim, o reduce() que tem 0 como acumulador inicial e um BinaryOperator, onde o 0
//		� somado com o primeiro elemento da stream (essa stream � de n�meros), e o resultado desta equa��o � a nova identidade
//		num�rica a ser somada com o proximo elemento num�rico da stream.
		result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	Voc� deve estar se perguntado: Ser� que agora eu melhoro a performance do processamneto com uso de mais de uma thread?
//	E a resposta � n�o, cada elemento sofre altera��es de boxing e unboxing, o que leva bastante tempo e custo de 
//	processamento, por enquanto o Parallel Stream continua invenc�vel. Voc� pode alternar entre o paralelismo e sequencialismo
//	 com os m�todo sequential() e parallel().
	private static void somaParallelStreamIterate(long num) {
		System.out.println("Soma Parallel Stream Iterate");
		long result = 0;
		long init = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	Com a Interface LongStream, o processamento de boxing e unboxing n�o ocorre, o processador ir� trabalhar com tipos primitivos,
//	al�m que, os n�meros ser�o gerados em tempo de execu��o, ou seja, n�o haver� uma itera��o. Ser� que eu poderia fornecer
//	Uma lambda cujo m�todo tivesse um �nico par�metro? Ser� que eu poderia fornecer at� 3 par�metros para esta lambda, desde
//	que o m�todo usado aceite mais par�metros? Lembrando que a regra de usar refrence method, � quando a lambda � simples, isso
//	 �, quando dentro da lambda, apenas um m�todo � chamado, idependente do n�mero de par�metros. Creio que o m�todo usado dentro
//	da lambda, precisa apenas pertencer � inst�ncia ou classe a qual os elementos da stream pertencem.
	private static void somaRangeClosedStream(long num) {
		System.out.println("Range Closed Stream Usando LongStream");
		long result = 0;
		long init = System.currentTimeMillis();
		result = LongStream.rangeClosed(1L, num).reduce(0L, (num1, num2) -> Long.sum(num1, num2));
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	Agora vamso usar o rangeClosed() da interface LongStream, do pacote stream, s� que com a pequena diferen�a, que � o paralelismo,
//	sim, uma stream paralela.
	private static void somaRangeClosedParallelStream(long num) {
		System.out.println("Range Closed Parallel Stream Usando LongStream");
		long result = 0;
		long init = System.currentTimeMillis();
		result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, (num1, num2) -> Long.sum(num1, num2));
		long end = System.currentTimeMillis();
		System.out.println(result + " " + (end - init) + " ms.");
	}
//	CONCLUS�ES: fa�a benchMark (medidas de performance), streams paralelos nem sempre s�o mais r�pidos que os sequenciais,
//	as vezes � melhor usar streams sequenciais, � bom tamb�m ficar atento se os streams que voc� est� a usar fazem uso de 
//	boxing e unboxing, esses recursos custam muito processamento e performance. Outro ponto � que: algumas opera��es s�o menos
//	eficientes quando paralelas do que em sequenciais, exemplo s�o liomit() e findFirst(), s�o bem melhores quest�o de performance
//	quando usadas sequencialmentes do que em pareaelelo, pois necessitam que os elementos estejam ordenados, agora, o findSAny()
//	� bem mais eficiente quando usado em modo paralelo, pois n�o necessita que ops elementos estejam ordenados, e voc� pode
//	chamar streams desordenadas usando unordened(). Outra quest�o a se considerar � custo total de processamento, e o n�mero de
//	elementos, se o coeficiente de performance for alto, geralmente � uma boa usar streams paralelas. Outro fator importante a ser considerado,
//	� a quantidade de dados, se for pequena, quase nunca usar streams paralelas ser� a decis�o certa, para estes casos, usar
//	streams seuqencialmente � a melhor op��o, outra coisa a lembrar � o tipo de cole��o a ser usada com streams, o ASrrayList
//	por exemplo, � muito melhor que o LinkedList para se usar em streams paralelas, pois, no LinkedList, voc� precis ficar
//	percorrendo a lista toda, cole��es de tamanho definido s�o bem melhores de se dividir em threads de stream paralelas, 
//	tamb�m � bom se atentar � isso.Uma stream paralela funciona assim:
/*	if(tarefa � pequena ou n�o pode ser dividida){
 		fa�a sequencialmente;
 	}
 	else{
 		dividir em duas tarefas;
 		chamar o m�todo recursivamente;
 		esperar todas as tarefas serem completadas;
 		combinar todos os resultados;
 		processamento do merge;
 	}*/
}
