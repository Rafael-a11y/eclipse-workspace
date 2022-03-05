package br.com.abc.javacore.Zcolecoes.test;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import br.com.abc.javacore.Zcolecoes.classes.Celular;
import br.com.abc.javacore.Zcolecoes.classes.Produto;

class CelularNomeComparator implements Comparator<Celular>{
	public int compare(Celular o1, Celular o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}

public class TreeSetTest {

	public static void main(String[] args) {
		/*Para trabalhar com NavigableSet e TreeSet, é preciso usar apenas dados que implementem
		 * Comparable<argumento > ou você precisar passar um Comparator<> no construtor*/
		
		Produto produto1 = new Produto("123", "Laptop Lenovo", 2000, 10); 
		Produto produto2 = new Produto("321", "Picanha", 10d, 10); 
		Produto produto3 = new Produto("879", "Teclado Razer", 1000, 0); 
		Produto produto4 = new Produto("012", "Samsung Galaxy S7 64Gb", 3250.5, 0);
		Produto produto5 = new Produto("023", "Samsung Galaxy S6 64Gb", 0, 0);
		Celular celular = new Celular("iPhone 7", "1234");
		NavigableSet<Produto> produtoNavigableSet = new TreeSet<>();
		NavigableSet<Celular> celularNavigableSet = new TreeSet<>(new CelularNomeComparator());
		celularNavigableSet.add(celular);
		produtoNavigableSet.add(produto1);
		produtoNavigableSet.add(produto2);
		produtoNavigableSet.add(produto3);
		produtoNavigableSet.add(produto4);
		produtoNavigableSet.add(produto5);
//		for(Celular celular1 : celularNavigableSet) {
//			System.out.println(celular1.toString());
//		}
		for(Produto p : produtoNavigableSet.descendingSet()) {
			System.out.println(p);
		}
		
		System.out.println("------------------------------------------------------------------------------------------");
		//lower < () -> menor que 
		//floor <= () -> menor ou igual que
		//higher > () -> maior que
		//ceiling >=() -> maior ou igual que
		System.out.println(produtoNavigableSet.size());
		//retorna e remove o primeiro elemento da lista.
		System.out.println(produtoNavigableSet.pollLast()); 
		System.out.println(produtoNavigableSet.size());
	}

}
