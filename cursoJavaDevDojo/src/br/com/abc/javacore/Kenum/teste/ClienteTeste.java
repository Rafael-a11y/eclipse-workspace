package br.com.abc.javacore.Kenum.teste;

import br.com.abc.javacore.Kenum.classes.Cliente;
import br.com.abc.javacore.Kenum.classes.TipoCliente;


public class ClienteTeste {
	
	public static void main(String[] args) {
		 
		Cliente cliente = new Cliente("Anna", TipoCliente.PESSOA_JURIDICA, Cliente.
				TipoPagamento.APRAZO);
		System.out.println(TipoCliente.PESSOA_FISICA.getId());
		System.out.println(cliente);
//		System.out.println(cliente.getTipo().getId());
		System.out.println(cliente.getTipo().getTipo());
		System.out.println(TipoCliente.PESSOA_FISICA.getTipo());
		
		
	}

}
