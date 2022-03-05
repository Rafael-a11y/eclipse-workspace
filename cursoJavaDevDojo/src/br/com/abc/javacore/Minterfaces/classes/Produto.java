package br.com.abc.javacore.Minterfaces.classes;

public class Produto implements Tributavel, Transportavel{

	private String nome;
	private double peso;
	private double preco;
	private double precoFinal;
	private double valorFrete;

	@Override
	public void calculaFrete() {
		// TODO Auto-generated method stub
		valorFrete = preco / peso * 0.1;
	}

	@Override
	public void calculaImposto() {
		// TODO Auto-generated method stub
		precoFinal = preco + (preco * Tributavel.IMPOSTO);
		
	}
	
	

	public Produto(String nome, double peso, double preco) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Produto {nome = " + nome + ", peso = " + peso + ", preco = " + preco 
				+ ", preco Final com imposto = " + precoFinal + ", valorFrete = " + valorFrete + "}";
	}

	public double getPrecoFinal() {
		return precoFinal;
	}

	public double getvalorFrete() {
		return valorFrete;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	} 
	
	
	
}
