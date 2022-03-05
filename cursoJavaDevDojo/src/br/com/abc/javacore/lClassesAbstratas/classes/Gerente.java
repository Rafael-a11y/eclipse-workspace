package br.com.abc.javacore.lClassesAbstratas.classes;

public class Gerente extends Funcionario {

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void imprime() {
		System.out.println("Dentro do método imprime");
	}

	public Gerente(String nome, String clt, double salario) {
		super(nome, clt, salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calculaSalario() {
		salario += (salario * 0.20);
	}
}
