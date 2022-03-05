package oo.composicao;

public class TesteDeMetodo {

	String nome;
	double preco;
	int qtde;
	
	void Teste(String nome, double preco, int qtde) {
		this.nome = nome;
		this.preco = preco;
		this.qtde = qtde;
	}
	
	void Teste(String nome, int qtde, boolean bo) {
		this.nome = nome;
		this.qtde = qtde;
	}
	
	void Testeint(int qtde, String nome, boolean bo) {
		this.nome = nome;
		this.qtde = qtde;
	}
	
	void Teste(int qtde, double preco) {
		this.qtde = qtde;
		this.preco = preco;
	}
}
