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

//Agrupamento de elementos. O pr�ximo � particionamento de elementos.
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
////		por g�nero, isso sem nenhuma l�gica mais complexa. Pois �, mas saiba que com
////		o agrupamento de Collectors, podemos fazer tudo isso em um alinha somente.
////		Aqui n�s fizemos um agrupamento por g�nero.
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
////		Agrupando por g�nero e quantidade
//		generoQtde = pessoas.stream().collect(Collectors.groupingBy(P -> P.getGenero(), Collectors.counting()));
//		System.out.println(generoQtde);
//		
////		Agrupando por g�nero e maior sal�rio
//		generoSalarioList = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.maxBy
//				(Comparator.comparing(Pessoa::getSalario))));
//		
////		Agrupando por g�nero e maior sal�rio se desfazendo do Objeto Optional.
//		generoAndSalario = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.collectingAndThen
//				(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)), Optional::get)));
//		System.out.println(generoAndSalario);
////		Agrupando por g�nero e estat�sticas salariais
//		generoAndEstatisticas = pessoas.stream().collect(Collectors.groupingBy
//				(Pessoa::getGenero, Collectors.summarizingDouble(Pessoa::getSalario)));
//		System.out.println(generoAndEstatisticas);
//		
////		Agrupando por g�nero e maioridade
//		Map<Genero, Set<Maioridade>> collect7 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
//            if (p.getIdade() < 18) return Maioridade.MENOR;
//            else return Maioridade.ADULTO;
//        }, Collectors.toSet())));
//        System.out.println(collect7);
//		Um groupingBy aceita outro groupingBy de par�metro.

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
//		Como podemos ver, escrevemos v�rias linhas para fazer este agrupamento por sexo, isso sem nenhuma l�gica
//		mais complexa. Vamos agora agrupar por sexo. Lembrando que o groupingBy � um m�todo est�tico, eu n�opreciso
//		chamar a classe antes do m�todo, porqu� fiz um import est�tico de todos os m�todos da classe Collectors.
		Map<Genero, List<Pessoa>> collect = pessoas.stream().collect(groupingBy(Pessoa::getGenero));
		System.out.println(collect);
//		Agrupando por maioridade.
		Map<Maioridade, List<Pessoa>> collect1 = pessoas.stream().collect(groupingBy
				(p -> p.getIdade() < 18 ? Maioridade.MENOR : Maioridade.ADULTO));
		System.out.println(collect1);
		
//		Agrupando por g�nero e maioridade.
		Map<Genero, Map<Maioridade, List<Pessoa>>> collect2 = pessoas.stream().collect(groupingBy
				(Pessoa::getGenero, groupingBy(p -> p.getIdade() < 18 ? Maioridade.MENOR :
					Maioridade.ADULTO)));
		System.out.println(collect2);
//		Agrupando por g�nero
		Map<Genero, Long> collect3 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, counting()));
		System.out.println("Por g�nero e quantidade: " + collect3);
//		Por g�nero e maior sal�rio.
		Map<Genero, Optional<Pessoa>> collect4 = pessoas.stream().collect(groupingBy
				(Pessoa::getGenero, maxBy(Comparator.comparingDouble(Pessoa::getSalario))));
		System.out.println(collect4.get(Genero.MASCULINO).get().getSalario());
		System.out.println(collect4.get(Genero.FEMININO).get().getSalario());
//		Por g�nero e maior sal�rio sem Optional<>. � importante dscartar o Optional, pois caso o Optional seja
//		vazio, n�o haver� nem o Optional, nem a chave, o que pode causar grandes dores de cabe�a. O m�todo
//		collectingAndThen(Collector<Pessoa, Object, Optional<Pessoa>> downstream, Function<Optional<Pessoa>, Object>)
//		espera uma opera��o com um Coollector de 3 par�metros e uma Function de 2 argumentos.
		Map<Genero, Pessoa> collect5 = pessoas.stream().collect(groupingBy(Pessoa::getGenero, collectingAndThen(maxBy
				(Comparator.comparing(Pessoa::getSalario)), Optional::get)));
		System.out.println(collect5);
//		Agrupando por g�nero e estat�sticas.
		Map<Genero, DoubleSummaryStatistics> collect6 = pessoas.stream().collect(groupingBy
				(Pessoa::getGenero, summarizingDouble(Pessoa::getSalario)));
		System.out.println(collect6);
//		Por g�nero e maioridade
//		pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> p.getIdade( < 18 ? Maioridade.MENOR : Maioridade.ADULTO, toList()))); 
		
	}
}
