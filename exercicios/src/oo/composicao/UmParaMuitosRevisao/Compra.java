package oo.composicao.UmParaMuitosRevisao;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	String cliente;
	List<Item> itens = new ArrayList<>();
	
	void adcionarItem(String nome, int quantidade, double preco) {
		this.adcionarItem(new Item(nome, quantidade, preco));
	}
	
	void adcionarItem(Item item) {
		itens.add(item);
		item.compra = this; // o item está contido em compra e a compra contida no item
	}
	
	double obterValorTotal() {
		double total = 0;
		for(Item item: itens) {
			total  += item.quantidade * item.preco;
		}
		return total;
	}
	
}
