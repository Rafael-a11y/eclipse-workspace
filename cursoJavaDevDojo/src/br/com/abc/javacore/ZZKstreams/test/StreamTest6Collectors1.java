package br.com.abc.javacore.ZZKstreams.test;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;
//Redução e sumarização de stream em um valor único.
public class StreamTest6Collectors1 {

	public static void main(String[] args) {
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
//		Sem utilizar Collectors para contar o número de elementos presentes na lista...
		System.out.println("Número de presentes na lista: " + pessoas.stream().count());
//		Utilizando a classe final Collectors do pacote stream...
		System.out.println("Número de presentes na lista: " + pessoas.stream().collect(Collectors.counting()));
//		Sem usar Collectors para obter o salário mais alto dentre as pessoas desta lista...
		System.out.println("Salário mais alto da lista: " + pessoas.stream().max(Comparator.comparing(Pessoa::getSalario))
				.get().getSalario());
//		Usando a classe final Collectors do pacote stream...
		System.out.println("Salário mais alto da lista: " + pessoas.stream().collect(Collectors.maxBy(Comparator
				.comparing(Pessoa::getSalario))).get().getSalario());
//		Sem usar Collectors para pegar o menor salário dentre as pessoas desta lista...
		System.out.println("Salário mais baixo da lista: " + pessoas.stream().min(Comparator.comparing(Pessoa::getSalario))
				.get().getSalario());
//		Usando a classe final Collectors do pacote stream paraa pegar o menor salário dentre as pessoas desta lista...
		System.out.println("Salário mais baixo da lista: " + pessoas.stream().collect(Collectors.minBy(Comparator
				.comparing(Pessoa::getSalario))).get().getSalario());
//		Sem usar a classe final Collectors do pacote stream para efetuaar a soma de todos os salários da lista...
		System.out.println("Soma de todos os salários das pessoas presentes nesta lista: " + pessoas.stream()
		.mapToDouble((p1) -> p1.getSalario()).sum());
		System.out.println("Soma de todos os salários das pessoas presentes nesta lista: " + pessoas.stream().collect(Collectors
				.summingDouble(Pessoa::getSalario)));
//		Sem usar a classe final Collectors do pacote stream para obter a média dos salários das pessoas dentro desta lista...
		System.out.println("A média de todos os salários: " + pessoas.stream().mapToDouble(Pessoa::getSalario)
				.average().getAsDouble());
//		Usando a classe final Collectors para obter a média de todos os salários das pessoas presentes nesta lista...
		System.out.println("A média de todos os salários: " + pessoas.stream().collect(Collectors.averagingDouble
				(Pessoa::getSalario)).doubleValue());
//		Obtendo todos os processamentos anteriores em um só objeto, DoubleSummaryStatistics retorna, o total de elementos,
//		o maior, o menor, a média e a soma de todos os salários das pessoas desta lista.
		DoubleSummaryStatistics dss = pessoas.stream().collect(Collectors.summarizingDouble(Pessoa::getSalario));
		System.out.println(dss);
//		Para obter cada um dos dados resultantes das operações, basta chamar o métodos a partir do objeto.
		System.out.println(dss.getCount());
//		Agora vamos imaginar um cenário onde, por qualquer motivo quue seja, você precisa concatenar todos os nomes...
//		Dentro do método collect(), você usa o método estático da classe final Collectors, o joining() que captura e junta
//		as Strings fornecidas no map(Pessoa::getNome), também há o método sobrecarregado onde você pode fornecer uma String
//		delimitadora, como a vírgula seguida de espaço, para a cada nome concatenado, ser inserido uma vírgula e um espaço.
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", ")));
	}

}
