package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.abc.javacore.Zcolecoes.classes.Produto;

class ProdutoNomeComparator implements Comparator<Produto>{
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}

public class SortProdutoTest {

	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<>();
		Produto[] produtoArray = new Produto[4];
		
		Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.00); 
		Produto produto2 = new Produto("321", "Picanha", 26.4); 
		Produto produto3 = new Produto("879", "Teclado Razer", 1000.0); 
		Produto produto4 = new Produto("012", "Samsung Galaxy S7 64Gb", 3250.5);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		produtoArray[0] = produto1;
		produtoArray[1] = produto2;
		produtoArray[2] = produto3;
		produtoArray[3] = produto4;
		
//		produtos.sort(new ProdutoNomeComparator());
		Collections.sort(produtos, new ProdutoNomeComparator());
		
//		for(Produto produto : produtos) {
//			System.out.println(produto);
//		}
//		System.out.println(Arrays.toString(produtoArray));
		Arrays.sort(produtoArray, new ProdutoNomeComparator());
//		for (int i = 0; i < produtoArray.length; i++) {
//			System.out.println(produtoArray[i]);
//		}
		for(Produto produto : produtoArray) {
			System.out.println(produto);
		}
	}
}
