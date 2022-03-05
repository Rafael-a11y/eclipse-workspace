package oo.composicao.UmParaMuitosRevisao;

public class CompraTeste {
	
	public static void main(String[] args) {
		
		Compra compra1 = new Compra();
		compra1.cliente = "João Pedro";
		compra1.adcionarItem("Caneta", 20, 7.45);
		compra1.adcionarItem("Borracha", 12, 3.89);
		compra1.adcionarItem("Caderno", 3, 18.89);
		System.out.println(compra1.obterValorTotal());
		System.out.println(compra1.itens.size());
		
		Item item1 = new Item ("Mochila", 2, 100.00);
		compra1.itens.add(item1);
		System.out.println(compra1.itens.size());
		System.out.println(item1.compra);
		
		
		
		
	}

}
