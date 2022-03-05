package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
//		Antes do Java7, podia-se adicionar qualquer tipo de dados, até surgir o Generics, antes disso, o foreach iterava um tipo
//		Object. Na versão 7 do Java, a sintaxe diamond foi implementada. Coleções de dados não podem guardarb tipos primitivos,
//		pois internamente o método equals() e hashCode() são implementados.
//		List nomes2 = new ArrayList();
//		nomes2.add("Rafael");
//		nomes2.add(new Aluno(1L, "Rafinha Bastos", "PQ@n@17"));
//		for(Object nome : nomes2) {
//			System.out.println(nome);
//		}
		List<String> nomes = new ArrayList<>();
		List<String> nomes2 = new ArrayList<>();
		List<String> nomes3 = new ArrayList<>();
		nomes.add("William");
		nomes.add("DevDojo");
		nomes2.add("William2");
		nomes2.add("DevDojo2");
		nomes3.add("Rafael");
		nomes3.add("Israel");
//		System.out.println("size: " + nomes.size());
//		System.out.println(nomes.remove("DevDojo"));
//		System.out.println("size: " + nomes.size());
		nomes.clear();
		nomes.addAll(nomes2);
		nomes.addAll(1, nomes3);
//		nomes.remove("DevDojo");
//		nomes.remove(0);
//		for(int i = 0; i < nomes.size(); i++) {
//			System.out.println(i);
//		}
		int size = nomes.size();
		
		for(int i = 0; i < size; i++) {
			System.out.println(nomes.get(i));
			nomes.add("Suane");
		}
		System.out.println(nomes.containsAll(nomes2));
		System.out.println(nomes.contains(nomes3));
//		System.out.println(nomes.add("Suane"));
//		System.out.println("Depois do forEach " + nomes.get(4));
//		System.out.println(nomes.get(5));
//		for(String nome : nomes) {
//			System.out.println(nome);
//		}
//		nomes.add("Suane");
//		for(String nome : nomes) {
//			System.out.println(nome);
//		}
		List<Integer> numeros = new ArrayList();
		numeros.add(10);
		for(Integer nums : numeros) {
			System.out.println(nums);
		}
		
	}
	
}
