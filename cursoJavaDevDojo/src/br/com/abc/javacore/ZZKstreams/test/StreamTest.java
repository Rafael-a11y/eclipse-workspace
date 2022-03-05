package br.com.abc.javacore.ZZKstreams.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

public class StreamTest {
	
	/*Pegar os 3 primeiros nomes das pessoas com menos de 25 anos, ordenados pelo nome. Agora vamos fazer isso utilizando o Java7,
	 * ou seja, antes da API DE STREAMS*/

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		Collections.sort(pessoas, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
	
	List<String> nomes = new ArrayList<String>();
	
		for(Pessoa pessoa : pessoas) {
			if(pessoa.getIdade() < 25) {
				nomes.add(pessoa.getNome());
				if(nomes.size() >= 3) {
					break;
				}
			}
		}
		System.out.println(nomes);
		/*Primeiro, se cria uma lista de String para receber o nomes que virão de pessoas. Primeiro chamamos o filter para
		 * fazer o filtro de pessoas com menos de 25 anos, depois usamos o sort para sortear os nomes, cujo parâmetro é o método
		 * estático da classe Comparator, comparing, que têm como parâmetros, um Function e uma keyExtractor, após isso, usamos o
		 * limit com número 3 de parâmetro para pegar somente os 3 primeiros nomes, seguido de um map para obter os nomes, e depois
		 * um collect que coleta os dados, seu parâmetro é o método da Classe Collectors, toList, que retorna uma lista com tais
		 * dados. Como estamos tentando por os resultados dentro de uma variável, necessariamente, precisamos ter um método
		 * terminal como o Collectors.toList. Depois usamos os skyp(1) para após pegar os 3 primeiros nomes, pular o primeiro, daí
		 * só será impresso os outros dois nomes */
		List<String> nomes2 = pessoas.stream().filter(p -> p.getIdade() < 25).sorted(Comparator.comparing(Pessoa::getNome)).limit(3)
				.skip(1).map(Pessoa::getNome).collect(Collectors.toList());
		System.out.println(nomes2);
//		Contando quantas pessoas tem menos de 25 anos. O método count() é do tipo terminal
		System.out.println("aaaaaa " + pessoas.stream().distinct().filter(p -> p.getIdade() < 25).limit(3).map(Pessoa::getNome).count());
//		Intermediate and Terminal, collect() é um método terminal. Métodos Intermediate não fazem nada até que um método terminal
//		seja inserido na pipeLine.
		pessoas.stream().forEach(System.out::println);
	}
}
