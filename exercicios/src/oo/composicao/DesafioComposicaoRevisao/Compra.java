package oo.composicao.DesafioComposicaoRevisao;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	
	final List<Item> itens = new ArrayList();
	
	void adicionarItem(Produto p, int qtde) {
		this.itens.add(new Item(p, qtde));
	}
	
	void adicionarItem(String nome, double preco, int qtde) {
		var produto = new Produto(nome, preco);//Posso criar objetos fora de suas classes, não só apenas
		this.itens.add(new Item(produto, qtde));//dentro da calsse que possui o main, mas em outras
	}											//classes de outros objetos, dentro ou fora de métodos.
	
	double obterValorTotal() {
		double total = 0;
		
		for(Item item : itens) {
			total += item.quantidade * item.produto.preco;
		}
		return total;
	}
	
	
}
