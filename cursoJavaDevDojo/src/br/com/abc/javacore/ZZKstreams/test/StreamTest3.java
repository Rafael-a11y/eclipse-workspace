package br.com.abc.javacore.ZZKstreams.test;

import java.util.Comparator;
import java.util.List;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

public class StreamTest3 {

	public static void main(String[] args) {
//		anyMatch() retorna true se pelo menos 1 elemento da Stream bater com o predicate fornecido.
//		allMatch() verifica se todos os elemntos da Stream batem com o predicate fornecido.
//		noneMatch() verifica se todos os elementos da Stream não batem com o predicate fornecido.
//		findAny() encontra qualquer elemento que bata com o predicate fornecido e retorna um Optional, sendo assim, pode-se chamar
//		métodos da classe Optional<T>, lembrando que findAny() econtra elementos diferentes, não retorna o primeiro elemento
//		que bata com o predicate. Já o findFirst() é bem parecido com o findAny(), a diferença é que findFirst() realmente encontra
//		o primeiro elemento que bata com o predicate e retorna um Optional deste elemento (exemplo: Optional<String>).
//		Usamos o sorted() junto de um método estático comparing e usamos uma lâmbda para sobrescrever o método, pois este já
//		espera uma Function de parâmetro, depois usamos o reverse para invertir ao contrário a ordem de ordenação,
		List<Pessoa> pessoas = Pessoa.bancoDePessoas();
		System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 4000));
		System.out.println(pessoas.stream().allMatch(p -> p.getIdade() > 18));
		System.out.println(pessoas.stream().noneMatch(p -> p.getIdade() < 18));
		pessoas.stream().filter(p -> p.getIdade() < 25).findAny()
				.ifPresent(p -> System.out.println(p.getNome()));
		
		pessoas.stream().filter(p -> p.getIdade() > 30)
		.sorted(Comparator.comparing(Pessoa::getIdade).reversed())
		.findFirst()
		.ifPresent(p -> System.out.println(p.getNome()));
		
		System.out.println(pessoas.stream().anyMatch(p -> p.getIdade() < 18));
		
		
	}

}	
