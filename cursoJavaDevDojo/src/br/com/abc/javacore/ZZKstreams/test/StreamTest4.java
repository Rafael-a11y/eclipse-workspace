package br.com.abc.javacore.ZZKstreams.test;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import static java.util.Arrays.asList;

import java.util.Optional;
public class StreamTest4{
	public static void main(String[] args) {
//		reduce() � uma opera��o terminal que usa uma entidade acumuladora que � usada
//		na opera��o de redu��o dos elementos da stream (isso acontece na lambda), o conceito
//		de reduce() � de reduzir a stream em um valor s�, como reduce() retorna um Optional
//		do tipo o qual a stream opera, � necess�rio usar o get() para puxar o valor.
		Optional<Integer> reduce = getStream().reduce((x, y) -> x + y);
		System.out.println(reduce.get());
		
//		Este reduce() sobrecarregado tem o 0 como primeiro argumento, diferente do 
//		exemplo anterior, este reduce() sobrecarregado retorna um tipo Wrapper, e n�o
//		um Optional<T>. Lembrando que quando voc� usa uma opera��o terminal em uma
//		stream, esta stream � consumida, n�o existe mais, e como um dos princ�pios da OO �
//		n�o copiar c�digo, criei o m�todo privado est�tico que getStream() que gera
//		uma nova stream exatamente igual � primeira para cada experimento que fiz
//		para esta aula.
		Integer soma = getStream().reduce(0, (x, y) -> x + y);
		System.out.println(soma);
		
//		Abaixo usamos method reference dentro do reduce(), j� que o m�todo da classe
//		Integer se encaixa perfeitamente no Functional Descriptor da lambda de um reduce(),
//		pode-se usar tal implemnta��o sem se preocupar com a stream, pois a itera��o �
//		feita internamente pela stream.
		Optional<Integer> soma2 = getStream().reduce(Integer::sum);
		System.out.println(soma2.get());
		
//		Tamb�m podemos fazer opera��es de multiplica��o com o reduce().
		Integer mult = getStream().reduce(1, (x, y) -> x * y);
		System.out.println(mult);
		
//		Usamos o reduce() para pegar o maior valor num�rico dentro da stream.
		Optional<Integer> max = getStream().reduce((x, y) -> x > y ? x : y);
		System.out.println(max.get());
		
//		Usamoss reference Method para achar o maior n�mero da stream, pois, como j�
//		citei anteriormente, o m�todo max() da classe Integer tem o Functional Descriptor
//		id�ntico a uma fun��o lambda BinbaryOperator.
		Optional<Integer> max2 = getStream().reduce(Integer::max);
		System.out.println(max2.get());
		
//		Usamos o filter() para pegar as pessoas com sal�rio maior que 4000, depois usamos o map() para criarmos uma nova stream
//		de Double (representando os sal�rios), se tent�ssemos usar o reduce() logo em seguida do filter, ter�amos um erro de
//		compila��o, pois a stream � de Pessoa, n�o de Double,n�o h� como somar pessoas, por isso usamos o map() para obter uma
//		nova stream desses valores, no final da opera��o o que � retornado � um Optional<Double>.
		Stream<Pessoa> streamPessoa = Pessoa.bancoDePessoas().stream();
		Optional<Double> somaSalario = streamPessoa
				.filter(p -> p.getSalario() > 4000)
				.map(Pessoa::getSalario)
				.reduce(Double::sum);
		System.out.println(somaSalario.get());
		
//		Como sempre fazemos boxing autom�tico dos Wrappers, podemos usar o mapToDouble que retorna um DoubleStream, classe que
//		cujos m�todos retornam tipos primitivos. Nos exemplos que usamos, lidamos com streams de poucos elementos, o que n�o
//		acontece em projetos reais, por isso � uma �tima pr�tica, mesmo no n�vel acad�mico, se preocupar com performance de
//		processamento desde sempre. 
		double somaDouble = Pessoa.bancoDePessoas().stream()
				.filter(p -> p.getSalario() > 4000)
				.mapToDouble(Pessoa::getSalario)
				.sum();
		System.out.println(somaDouble);
		
//		E caso voc� precise reverter o DoubleStream de volta para a stream de Double? Pra isso serve o boxed() da classe
//		DoubleStream -> Retorna um stream que consiste nos elementos deste stream, encaixotado em Double.
		DoubleStream doubleStream = Pessoa.bancoDePessoas().stream().filter(p -> p.getSalario() > 4000)
		.mapToDouble(Pessoa::getSalario);
		
		Stream<Double> doubleStream2 = doubleStream.boxed();
	}

	private static Stream<Integer> getStream() {
		return asList(1, 2, 3, 4, 5, 6).stream();
	}
}
