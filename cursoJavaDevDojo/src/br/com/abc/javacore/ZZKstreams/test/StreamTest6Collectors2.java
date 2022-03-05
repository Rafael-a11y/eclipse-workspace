package br.com.abc.javacore.ZZKstreams.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.*;

import br.com.abc.javacore.ZZKstreams.classes.Genero;
import br.com.abc.javacore.ZZKstreams.classes.Maioridade;
import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

//Agrupamento de elementos. O próximo é particionamento de elementos.
public class StreamTest6Collectors2 {

	public static void main(String[] args) {
//		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
//		Map<Genero, List<Pessoa>> generoListMap = new HashMap<Genero, List<Pessoa>>();
//		Map<Maioridade, List<Pessoa>> maioridadeListMap;
//		Map<Genero, Long> generoQtde;
//		Map<Genero, Optional<Pessoa>> generoSalarioList;
//		Map<Genero, DoubleSummaryStatistics> generoAndEstatisticas;
//		Map<Genero, Pessoa> generoAndSalario;
//		List<Pessoa> masculinos = new ArrayList<Pessoa>();
//		List<Pessoa> femininos = new ArrayList<Pessoa>();
//		
//		for(Pessoa pessoa: pessoas) {
//			if(pessoa.getGenero() == Genero.MASCULINO)
//				masculinos.add(pessoa);
//			if(pessoa.getGenero() == Genero.FEMININO)
//				femininos.add(pessoa);
//		}		
//		generoListMap.put(Genero.FEMININO, femininos);
//		generoListMap.put(Genero.MASCULINO, masculinos);
//		
//		System.out.println(generoListMap);
//		
////		Pois bem, repare que criamos cerca de 15 linhas apenas para agrupar as pessoas
////		por gênero, isso sem nenhuma lógica mais complexa. Pois é, mas saiba que com
////		o agrupamento de Collectors, podemos fazer tudo isso em um alinha somente.
////		Aqui nós fizemos um agrupamento por gênero.
//		System.out.println(pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero)));
//		
////		Agora um agrupamento por maioridade.
//		maioridadeListMap = pessoas.stream().collect(Collectors.groupingBy
//				(p -> p.getIdade() >= 18 ? Maioridade.ADULTO : Maioridade.MENOR));
//		
//		System.out.println(maioridadeListMap);
//		Map<Genero, Map<Maioridade, List<Pessoa>>> generoEMaioridade;
//		pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.groupingBy
//				(p -> p.getIdade() >= 18 ? Maioridade.ADULTO : Maioridade.MENOR)));
//		
////		Agrupando por gênero e quantidade
//		generoQtde = pessoas.stream().collect(Collectors.groupingBy(P -> P.getGenero(), Collectors.counting()));
//		System.out.println(generoQtde);
//		
////		Agrupando por gênero e maior salário
//		generoSalarioList = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.maxBy
//				(Comparator.comparing(Pessoa::getSalario))));
//		
////		Agrupando por gênero e maior salário se desfazendo do Objeto Optional.
//		generoAndSalario = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.collectingAndThen
//				(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)), Optional::get)));
//		System.out.println(generoAndSalario);
////		Agrupando por gênero e estatísticas salariais
//		generoAndEstatisticas = pessoas.stream().collect(Collectors.groupingBy
//				(Pessoa::getGenero, Collectors.summarizingDouble(Pessoa::getSalario)));
//		System.out.println(generoAndEstatisticas);
//		
////		Agrupando por gênero e maioridade
//		Map<Genero, Set<Maioridade>> collect7 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
//            if (p.getIdade() < 18) return Maioridade.MENOR;
//            else return Maioridade.ADULTO;
//        }, Collectors.toSet())));
//        System.out.println(collect7);
//		Um groupingBy aceita outro groupingBy de parâmetro.

		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();
		List<Pessoa> masculinos = new ArrayList<>();
		List<Pessoa> femininos = new ArrayList<>();
		for(Pessoa pessoa: pessoas) {
			if(pessoa.getGenero().equals(Genero.FEMININO)) femininos.add(pessoa);
			else masculinos.add(pessoa);
		}
		generoListMap.put(Genero.FEMININO, femininos);
		generoListMap.put(Genero.MASCULINO, masculinos);
		System.out.println(generoListMap);
//		Como podemos ver, escrevemos várias linhas para fazer este agrupamento por sexo, isso sem nenhuma lógica
//		mais complexa. Vamos agora agrupar por sexo. Lembrando que o groupingBy é um método estático, eu nãopreciso
//		chamar a classe antes do método, porquê fiz um import estático de todos os métodos da classe Collectors.
		Map<Genero, List<Pessoa>> collect = pessoas.stream().collect(groupingBy(Pessoa::getGenero));
		System.out.println(collect);
//		Agrupando por maioridade.
		Map<Maioridade, List<Pessoa>> collect1 = pessoas.stream().collect(groupingBy
				(p -> p.getIdade() < 18 ? Maioridade.MENOR : Maioridade.ADULTO));
		System.out.println(collect1);
		
//		Agrupando por gênero e maioridade.
		Map<Genero, Map<Maioridade, List<Pessoa>>> collect2 = pessoas.stream().collect(groupingBy
				(Pessoa::getGenero, groupingBy(p -> p.getIdade() < 18 ? Maioridade.MENOR :
					Maioridade.ADULTO)));
		System.out.println(collect2);
//		Agrupando por gênero
		Map<Genero, Long> collect3 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, counting()));
		System.out.println("Por gênero e quantidade: " + collect3);
//		Por gênero e maior salário.
		Map<Genero, Optional<Pessoa>> collect4 = pessoas.stream().collect(groupingBy
				(Pessoa::getGenero, maxBy(Comparator.comparingDouble(Pessoa::getSalario))));
		System.out.println(collect4.get(Genero.MASCULINO).get().getSalario());
		System.out.println(collect4.get(Genero.FEMININO).get().getSalario());
//		Por gênero e maior salário sem Optional<>. é importante dscartar o Optional, pois caso o Optional seja
//		vazio, não haverá nem o Optional, nem a chave, o que pode causar grandes dores de cabeça. O método
//		collectingAndThen(Collector<Pessoa, Object, Optional<Pessoa>> downstream, Function<Optional<Pessoa>, Object>)
//		espera uma operação com um Coollector de 3 parâmetros e uma Function de 2 argumentos.
		Map<Genero, Pessoa> collect5 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, collectingAndThen(maxBy
				(Comparator.comparing(Pessoa::getSalario)), Optional::get)));
		System.out.println(collect5);
//		Agrupando por gênero e estatísticas.
		Map<Genero, DoubleSummaryStatistics> collect6 = pessoas.stream().collect(groupingBy
				(Pessoa::getGenero, summarizingDouble(Pessoa::getSalario)));
		System.out.println(collect6);
//		Por gênero e maioridade
//		pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> p.getIdade( < 18 ? Maioridade.MENOR : Maioridade.ADULTO, toList()))); 
		
	}
}
