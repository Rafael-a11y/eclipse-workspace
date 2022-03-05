package br.com.abc.javacore.ZZKstreams.test;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import static java.util.Arrays.asList;

import java.util.Optional;
public class StreamTest4{
	public static void main(String[] args) {
//		reduce() é uma operação terminal que usa uma entidade acumuladora que é usada
//		na operação de redução dos elementos da stream (isso acontece na lambda), o conceito
//		de reduce() é de reduzir a stream em um valor só, como reduce() retorna um Optional
//		do tipo o qual a stream opera, é necessário usar o get() para puxar o valor.
		Optional<Integer> reduce = getStream().reduce((x, y) -> x + y);
		System.out.println(reduce.get());
		
//		Este reduce() sobrecarregado tem o 0 como primeiro argumento, diferente do 
//		exemplo anterior, este reduce() sobrecarregado retorna um tipo Wrapper, e não
//		um Optional<T>. Lembrando que quando você usa uma operação terminal em uma
//		stream, esta stream é consumida, não existe mais, e como um dos princípios da OO é
//		não copiar código, criei o método privado estático que getStream() que gera
//		uma nova stream exatamente igual à primeira para cada experimento que fiz
//		para esta aula.
		Integer soma = getStream().reduce(0, (x, y) -> x + y);
		System.out.println(soma);
		
//		Abaixo usamos method reference dentro do reduce(), já que o método da classe
//		Integer se encaixa perfeitamente no Functional Descriptor da lambda de um reduce(),
//		pode-se usar tal implemntação sem se preocupar com a stream, pois a iteração é
//		feita internamente pela stream.
		Optional<Integer> soma2 = getStream().reduce(Integer::sum);
		System.out.println(soma2.get());
		
//		Também podemos fazer operações de multiplicação com o reduce().
		Integer mult = getStream().reduce(1, (x, y) -> x * y);
		System.out.println(mult);
		
//		Usamos o reduce() para pegar o maior valor numérico dentro da stream.
		Optional<Integer> max = getStream().reduce((x, y) -> x > y ? x : y);
		System.out.println(max.get());
		
//		Usamoss reference Method para achar o maior número da stream, pois, como já
//		citei anteriormente, o método max() da classe Integer tem o Functional Descriptor
//		idêntico a uma função lambda BinbaryOperator.
		Optional<Integer> max2 = getStream().reduce(Integer::max);
		System.out.println(max2.get());
		
//		Usamos o filter() para pegar as pessoas com salário maior que 4000, depois usamos o map() para criarmos uma nova stream
//		de Double (representando os salários), se tentássemos usar o reduce() logo em seguida do filter, teríamos um erro de
//		compilação, pois a stream é de Pessoa, não de Double,não há como somar pessoas, por isso usamos o map() para obter uma
//		nova stream desses valores, no final da operação o que é retornado é um Optional<Double>.
		Stream<Pessoa> streamPessoa = Pessoa.bancoDePessoas().stream();
		Optional<Double> somaSalario = streamPessoa
				.filter(p -> p.getSalario() > 4000)
				.map(Pessoa::getSalario)
				.reduce(Double::sum);
		System.out.println(somaSalario.get());
		
//		Como sempre fazemos boxing automático dos Wrappers, podemos usar o mapToDouble que retorna um DoubleStream, classe que
//		cujos métodos retornam tipos primitivos. Nos exemplos que usamos, lidamos com streams de poucos elementos, o que não
//		acontece em projetos reais, por isso é uma ótima prática, mesmo no nível acadêmico, se preocupar com performance de
//		processamento desde sempre. 
		double somaDouble = Pessoa.bancoDePessoas().stream()
				.filter(p -> p.getSalario() > 4000)
				.mapToDouble(Pessoa::getSalario)
				.sum();
		System.out.println(somaDouble);
		
//		E caso você precise reverter o DoubleStream de volta para a stream de Double? Pra isso serve o boxed() da classe
//		DoubleStream -> Retorna um stream que consiste nos elementos deste stream, encaixotado em Double.
		DoubleStream doubleStream = Pessoa.bancoDePessoas().stream().filter(p -> p.getSalario() > 4000)
		.mapToDouble(Pessoa::getSalario);
		
		Stream<Double> doubleStream2 = doubleStream.boxed();
	}

	private static Stream<Integer> getStream() {
		return asList(1, 2, 3, 4, 5, 6).stream();
	}
}
