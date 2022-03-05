package lambdas;

import lambda.teste.ParaTeste;

//Para uma classe poder implementar uma interface, esta deve ser importada

public class Produto extends Object implements ParaTeste {
	
	final String nome;
	final double preco;
	final double desconto;
	public Produto(String nome, double preco, double desconto) {
//		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public String toString() {
		return nome;
	}
	
	@Override
	public boolean trueOrFalse() {
		// TODO Auto-generated method stub
		return true;
	}

}
