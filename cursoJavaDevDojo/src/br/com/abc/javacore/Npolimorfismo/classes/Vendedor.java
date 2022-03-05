package br.com.abc.javacore.Npolimorfismo.classes;

public class Vendedor extends Funcionario {

	private double totalVendas;
	
	public Vendedor () {
		// TODO Auto-generated constructor stub
	}

	public Vendedor(String nome, double salario, double totalVendas) {
		super(nome, salario);
		this.totalVendas = totalVendas;
		// TODO Auto-generated constructor stub
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

	@Override
	public void calcularPagamento() {
		// TODO Auto-generated method stub
		this.salario = this.salario + (totalVendas * 0.05);
	}
	
	

}
