package oo.composicao.DesafioComposicaoRevisao;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	final String nome;
	
	Cliente(String nome){
		this.nome = nome;
	}
	
	final List<Compra> compras = new ArrayList();
	
	void adicionarCompra(Compra compra) {
		this.compras.add(compra);
	}
	
	double obterValorTotal() {
		double total = 0;
		
		for(Compra compra: compras) {
			total += compra.obterValorTotal();
		}
		return total;
	}
	
	
}
