package br.com.abc.javacore.Npolimorfismo.classes;

public class RelatorioPagamento {

	public void relatorioPagamentoGerente(Gerente gerente) {
		System.out.println("Gerando relatório de pagamento para a gerência...");
		gerente.calcularPagamento();
		System.out.println("Nome: " + gerente.getNome());
		System.out.println("Salário deste mês: " + gerente.getSalario());
	}
	
	public void relatorioPagamentoVendedor(Vendedor vendedor) {
		System.out.println("Gerando relatório de pagamento para os vendedores...");
		vendedor.calcularPagamento();
		System.out.println("Nome: " + vendedor.getNome());
		System.out.println("Salário deste mês: " + vendedor.getSalario());
	}
	
	public void relatorioPagamentoFuncionario(Funcionario funcionario) {
		System.out.println("Gerando relatório de pagamento...");
		funcionario.calcularPagamento();
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Salário deste mês: " + funcionario.getSalario());
		if(funcionario instanceof Gerente) {
			System.out.println("Participação nos lucros: "
			+ ((Gerente) funcionario).getPnl());
		}
		if(funcionario instanceof Vendedor) {
			System.out.println("Total em vendas: " +
		((Vendedor) funcionario).getTotalVendas());
		}
	}
	
	public void relatorioPagamento(Funcionario funcionario) {
		if( funcionario instanceof Gerente) {
			System.out.println("Gerando relatório de pagamento para a gerência...");
			funcionario.calcularPagamento();
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salário deste mês: " + funcionario.getSalario());
			System.out.println("Gerente imprimido.");
		}
		else if(funcionario instanceof Vendedor) {
			System.out.println("Gerando relatório de pagamento para os vendedores...");
			funcionario.calcularPagamento();
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salário deste mês: " + funcionario.getSalario());
			System.out.println("Vendedor imprimido.");
		}
	}
}
