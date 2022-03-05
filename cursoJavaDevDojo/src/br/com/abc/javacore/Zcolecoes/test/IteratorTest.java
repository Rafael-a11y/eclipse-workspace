package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

public class IteratorTest {

	public static void main(String[] args) {
		
List<Produto> produtos = new ArrayList<>();
		
		Produto produto1 = new Produto("123", "Laptop Lenovo", 2000, 10); 
		Produto produto2 = new Produto("321", "Picanha", 10d, 10); 
		Produto produto3 = new Produto("879", "Teclado Razer", 1000, 0); 
		Produto produto4 = new Produto("012", "Samsung Galaxy S7 64Gb", 3250.5, 0);
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		/*Para alterar a lista em tempo de execução, é confiável usar o Iterator<argument>.
		 * */
		Iterator<Produto> produtoIterator = produtos.iterator();
		while(produtoIterator.hasNext()) { 
			if(produtoIterator.next().getQuantidade() == 0) {
				produtoIterator.remove();
			}
		}
		System.out.println(produtos.size());
//		hasNext() -> verifica se há um próximo elemento na lista;
//		next() -> pega o proximo elemento da lista
		
	}

}
