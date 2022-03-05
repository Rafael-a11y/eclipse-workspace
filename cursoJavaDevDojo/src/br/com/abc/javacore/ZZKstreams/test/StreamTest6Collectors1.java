package br.com.abc.javacore.ZZKstreams.test;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;
//Redu��o e sumariza��o de stream em um valor �nico.
public class StreamTest6Collectors1 {

	public static void main(String[] args) {
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
//		Sem utilizar Collectors para contar o n�mero de elementos presentes na lista...
		System.out.println("N�mero de presentes na lista: " + pessoas.stream().count());
//		Utilizando a classe final Collectors do pacote stream...
		System.out.println("N�mero de presentes na lista: " + pessoas.stream().collect(Collectors.counting()));
//		Sem usar Collectors para obter o sal�rio mais alto dentre as pessoas desta lista...
		System.out.println("Sal�rio mais alto da lista: " + pessoas.stream().max(Comparator.comparing(Pessoa::getSalario))
				.get().getSalario());
//		Usando a classe final Collectors do pacote stream...
		System.out.println("Sal�rio mais alto da lista: " + pessoas.stream().collect(Collectors.maxBy(Comparator
				.comparing(Pessoa::getSalario))).get().getSalario());
//		Sem usar Collectors para pegar o menor sal�rio dentre as pessoas desta lista...
		System.out.println("Sal�rio mais baixo da lista: " + pessoas.stream().min(Comparator.comparing(Pessoa::getSalario))
				.get().getSalario());
//		Usando a classe final Collectors do pacote stream paraa pegar o menor sal�rio dentre as pessoas desta lista...
		System.out.println("Sal�rio mais baixo da lista: " + pessoas.stream().collect(Collectors.minBy(Comparator
				.comparing(Pessoa::getSalario))).get().getSalario());
//		Sem usar a classe final Collectors do pacote stream para efetuaar a soma de todos os sal�rios da lista...
		System.out.println("Soma de todos os sal�rios das pessoas presentes nesta lista: " + pessoas.stream()
		.mapToDouble((p1) -> p1.getSalario()).sum());
		System.out.println("Soma de todos os sal�rios das pessoas presentes nesta lista: " + pessoas.stream().collect(Collectors
				.summingDouble(Pessoa::getSalario)));
//		Sem usar a classe final Collectors do pacote stream para obter a m�dia dos sal�rios das pessoas dentro desta lista...
		System.out.println("A m�dia de todos os sal�rios: " + pessoas.stream().mapToDouble(Pessoa::getSalario)
				.average().getAsDouble());
//		Usando a classe final Collectors para obter a m�dia de todos os sal�rios das pessoas presentes nesta lista...
		System.out.println("A m�dia de todos os sal�rios: " + pessoas.stream().collect(Collectors.averagingDouble
				(Pessoa::getSalario)).doubleValue());
//		Obtendo todos os processamentos anteriores em um s� objeto, DoubleSummaryStatistics retorna, o total de elementos,
//		o maior, o menor, a m�dia e a soma de todos os sal�rios das pessoas desta lista.
		DoubleSummaryStatistics dss = pessoas.stream().collect(Collectors.summarizingDouble(Pessoa::getSalario));
		System.out.println(dss);
//		Para obter cada um dos dados resultantes das opera��es, basta chamar o m�todos a partir do objeto.
		System.out.println(dss.getCount());
//		Agora vamos imaginar um cen�rio onde, por qualquer motivo quue seja, voc� precisa concatenar todos os nomes...
//		Dentro do m�todo collect(), voc� usa o m�todo est�tico da classe final Collectors, o joining() que captura e junta
//		as Strings fornecidas no map(Pessoa::getNome), tamb�m h� o m�todo sobrecarregado onde voc� pode fornecer uma String
//		delimitadora, como a v�rgula seguida de espa�o, para a cada nome concatenado, ser inserido uma v�rgula e um espa�o.
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", ")));
	}

}
