package br.com.abc.javacore.Npolimorfismo.test;

import br.com.abc.javacore.Npolimorfismo.classes.Funcionario;
import br.com.abc.javacore.Npolimorfismo.classes.Gerente;
import br.com.abc.javacore.Npolimorfismo.classes.RelatorioPagamento;
import br.com.abc.javacore.Npolimorfismo.classes.Vendedor;

public class PolimorfismoTest {

	public static void main(String[] args) {
		
		Gerente g = new Gerente("Oswaldo", 5000, 2000);
		Vendedor v = new Vendedor("Yuri", 2000, 20000);
		RelatorioPagamento relatorio = new RelatorioPagamento();
		Funcionario f = g;
		
		relatorio.relatorioPagamentoFuncionario(g);
		System.out.println();
		relatorio.relatorioPagamentoFuncionario(v);
//		
	}

}
