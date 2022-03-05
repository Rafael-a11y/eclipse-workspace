package br.com.abc.javacore.Zcolecoes.test;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.abc.javacore.Zcolecoes.classes.Produto;
public class SetTest {

	public static void main(String[] args) {

		Produto produto1 = new Produto("123", "Laptop Lenovo", 2000, 10); 
		Produto produto2 = new Produto("321", "Picanha", 10d, 10); 
		Produto produto3 = new Produto("879", "Teclado Razer", 1000, 0); 
		Produto produto4 = new Produto("012", "Samsung Galaxy S7 64Gb", 3250.5, 0);
		Produto produto5 = new Produto("012", "Samsung Galaxy S6 64Gb", 3250.5, 0);
		/*HashSet faz uso do hashCode(). A interface Set não é indexada.
		 * Sempre que você inserir elementos em um set, ele fará uso de equals() e
		 * hashCode(), equals() para saber se o elemento é repetido e o hashCode() para
		 * organizá-lo no Set, então a principal característica do Set é que ele não é
		 * ordenado. LinkedHashSet e HashSet implementam a interface Set, a diferença
		 * é que o primeiro mantém a ordem de inserção, e o outro não*/
		Set<Produto> produtoSet = new LinkedHashSet<Produto>();
		produtoSet.add(produto1);
		produtoSet.add(produto2);
		produtoSet.add(produto3);
		produtoSet.add(produto4);
		produtoSet.add(produto5);
		
		
		for(Produto p: produtoSet) {
			System.out.println(p);
		}
		
		
		
	}

}
