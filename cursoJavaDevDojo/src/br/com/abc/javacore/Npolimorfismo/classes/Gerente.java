package br.com.abc.javacore.Npolimorfismo.classes;

public class Gerente extends Funcionario{

	private double pnl;
	
	public Gerente() {
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, double salario, double pnl) {
		super(nome, salario);
		this.pnl = pnl;
		// TODO Auto-generated constructor stub
	}

	public double getPnl() {
		return pnl;
	}

	public void setPnl(double pnl) {
		this.pnl = pnl;
	}

	@Override
	public void calcularPagamento() {
		// TODO Auto-generated method stub
		this.salario += pnl;
	}
	
	
	
	

}
