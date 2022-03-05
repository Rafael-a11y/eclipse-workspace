package br.com.abc.javacore.Npolimorfismo.classes;

public class RelatorioPagamento {

	public void relatorioPagamentoGerente(Gerente gerente) {
		System.out.println("Gerando relat�rio de pagamento para a ger�ncia...");
		gerente.calcularPagamento();
		System.out.println("Nome: " + gerente.getNome());
		System.out.println("Sal�rio deste m�s: " + gerente.getSalario());
	}
	
	public void relatorioPagamentoVendedor(Vendedor vendedor) {
		System.out.println("Gerando relat�rio de pagamento para os vendedores...");
		vendedor.calcularPagamento();
		System.out.println("Nome: " + vendedor.getNome());
		System.out.println("Sal�rio deste m�s: " + vendedor.getSalario());
	}
	
	public void relatorioPagamentoFuncionario(Funcionario funcionario) {
		System.out.println("Gerando relat�rio de pagamento...");
		funcionario.calcularPagamento();
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Sal�rio deste m�s: " + funcionario.getSalario());
		if(funcionario instanceof Gerente) {
			System.out.println("Participa��o nos lucros: "
			+ ((Gerente) funcionario).getPnl());
		}
		if(funcionario instanceof Vendedor) {
			System.out.println("Total em vendas: " +
		((Vendedor) funcionario).getTotalVendas());
		}
	}
	
	public void relatorioPagamento(Funcionario funcionario) {
		if( funcionario instanceof Gerente) {
			System.out.println("Gerando relat�rio de pagamento para a ger�ncia...");
			funcionario.calcularPagamento();
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Sal�rio deste m�s: " + funcionario.getSalario());
			System.out.println("Gerente imprimido.");
		}
		else if(funcionario instanceof Vendedor) {
			System.out.println("Gerando relat�rio de pagamento para os vendedores...");
			funcionario.calcularPagamento();
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Sal�rio deste m�s: " + funcionario.getSalario());
			System.out.println("Vendedor imprimido.");
		}
	}
}
