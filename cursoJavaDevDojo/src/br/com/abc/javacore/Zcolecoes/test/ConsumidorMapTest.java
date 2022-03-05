package br.com.abc.javacore.Zcolecoes.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.abc.javacore.Zcolecoes.classes.Celular;
import br.com.abc.javacore.Zcolecoes.classes.Consumidor;
import br.com.abc.javacore.Zcolecoes.classes.Produto;

public class ConsumidorMapTest {

	public static void main(String[] args) {
		/*Ao tentar adicionar uma chave que já exista, oq ue será sobrescrito é o valor*/
		Consumidor consumidor = new Consumidor("William Suane", "122");
		Consumidor consumidor2 = new Consumidor("DevDojo", "321");
		Consumidor consumidor3 = new Consumidor("DevDojo2", "321");
		
		Produto produto1 = new Produto("123", "Laptop Lenovo", 2000.00); 
		Produto produto2 = new Produto("321", "Picanha", 26.4); 
		Produto produto3 = new Produto("879", "Teclado Razer", 1000.0); 
		Produto produto4 = new Produto("012", "Samsung Galaxy S7 64Gb", 3250.5);
//		Map<Consumidor, List<Celular>, List<Produto>> listas = new HashMap<>();
		Map<Consumidor, List<Produto>> map = new HashMap<>();
		List<Produto> produtosCon1 = new ArrayList<>();
		produtosCon1.add(produto1);
		produtosCon1.add(produto2);
		List<Produto> produtosCon2 = new ArrayList<>();
		produtosCon2.add(produto3);
		produtosCon2.add(produto4);
		
		map.put(consumidor, produtosCon1);
		map.put(consumidor2, produtosCon2);
		map.put(consumidor3, produtosCon1);
		for(Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
			System.out.println();
			System.out.print(entry.getKey().getNome() + " -> ");
			for(Produto produto : entry.getValue()) {
				System.out.print(produto.getNome() + ", ");
			}
		}
		System.out.println("\n");
		System.out.println(map.size());
		
	}

}
