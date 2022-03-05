package oo.composicao.UmParaMuitos;

import java.util.ArrayList;

public class Compra {
	
	String cliente;
	ArrayList<Item> itens = new ArrayList<>();
	
	void adicionarItem(String nome, int quantidade, double preco) {
		this.adicionarItem(new Item(nome, quantidade, preco));
	}
	void adicionarItem(Item item) {
		this.itens.add(item);
		item.compra = this;
	}
	/*
	 * O parâmetro item, por ser do tipo Item, tem acesso
	 * ao atributo compra do tipo Compra, ao usar this,
	 * estou me referindo a classe Item, desta forma,
	 * estou adicionando a compra ao Item, o objeto compra1
	 * passa a estar dentro do item a ser adicionado na List
	 */
	
	double obterValorTotal() {
		double total = 0;
		
		for(Item item: itens) {
			total += item.quantidade * item.preco;
		}
		
		return total;
		
	}
	
	/*
	 * Ao fazer foreach dentro da classe, dá certo, mas se fizer
	 * foreach em outra classe, tem que especificar a classe que
	 * obtem a List a ser percorrida. Exemplo, no método acima
	 * obterValorTotal(), é feito um foreach em cima da List, mas
	 * caso eu tente fazer um foreach em CompraTeste, tenho que
	 * usar a notação ponto: (Item item : Compra1.itens).
	 */

}
