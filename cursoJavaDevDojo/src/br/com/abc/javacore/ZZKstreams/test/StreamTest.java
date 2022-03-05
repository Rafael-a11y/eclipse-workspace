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
		/*Primeiro, se cria uma lista de String para receber o nomes que vir�o de pessoas. Primeiro chamamos o filter para
		 * fazer o filtro de pessoas com menos de 25 anos, depois usamos o sort para sortear os nomes, cujo par�metro � o m�todo
		 * est�tico da classe Comparator, comparing, que t�m como par�metros, um Function e uma keyExtractor, ap�s isso, usamos o
		 * limit com n�mero 3 de par�metro para pegar somente os 3 primeiros nomes, seguido de um map para obter os nomes, e depois
		 * um collect que coleta os dados, seu par�metro � o m�todo da Classe Collectors, toList, que retorna uma lista com tais
		 * dados. Como estamos tentando por os resultados dentro de uma vari�vel, necessariamente, precisamos ter um m�todo
		 * terminal como o Collectors.toList. Depois usamos os skyp(1) para ap�s pegar os 3 primeiros nomes, pular o primeiro, da�
		 * s� ser� impresso os outros dois nomes */
		List<String> nomes2 = pessoas.stream().filter(p -> p.getIdade() < 25).sorted(Comparator.comparing(Pessoa::getNome)).limit(3)
				.skip(1).map(Pessoa::getNome).collect(Collectors.toList());
		System.out.println(nomes2);
//		Contando quantas pessoas tem menos de 25 anos. O m�todo count() � do tipo terminal
		System.out.println("aaaaaa " + pessoas.stream().distinct().filter(p -> p.getIdade() < 25).limit(3).map(Pessoa::getNome).count());
//		Intermediate and Terminal, collect() � um m�todo terminal. M�todos Intermediate n�o fazem nada at� que um m�todo terminal
//		seja inserido na pipeLine.
		pessoas.stream().forEach(System.out::println);
	}
}
