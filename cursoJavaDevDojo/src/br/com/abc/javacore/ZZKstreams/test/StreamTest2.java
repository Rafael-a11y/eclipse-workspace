package br.com.abc.javacore.ZZKstreams.test;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//	Quando trabalhares com stream, quando devemos usar o map() e o flatMap()? É o que essa aula responderá.
//	O map() aplica a função para cadsa elemento e retornando os dados em uma stream(), já o flatMap() deve ser usado qaundo há
//vários valores e você quer concatenar esses valores em um só. 
public class StreamTest2 {
	public static void main(String[] args) {
//		List<List<String>> nomes = new ArrayList<>();
//		nomes.add(asList("DevDojo", "Valeu por aumentar a letra"));
//		nomes.add(asList("William", "pq você demorou 180 para isso?"));
////		Transforma numa lista só
//		List<String> collect = nomes.stream().flatMap(Collection::stream).collect(Collectors.toList());
//		collect.forEach(System.out::println);
		
		List<String> palavras = asList("Ola", "Goku");
		String[] split = palavras.get(0).split("");
//		System.out.println(Arrays.toString(split));
//		Uma lista de array de String
		List<String[]> collect1 = palavras.stream().map(p -> p.split("")).collect(Collectors.toList());
//		Percorrendo os valores dos arrays dentro da lista
		for(String[] a : collect1) {
			System.out.println(Arrays.toString(a));
		}
//		Stream<String> stream = Arrays.stream((String[]) palavras.toArray());
//		Uma lista de String
		List<String> collect2 = palavras.stream().map(p -> p.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
		for(String a : collect2) {
			System.out.println(a);
		}
//		System.out.println(collect2);
	}
}
