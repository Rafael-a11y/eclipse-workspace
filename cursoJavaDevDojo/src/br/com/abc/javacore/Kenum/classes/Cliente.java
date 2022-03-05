package br.com.abc.javacore.Kenum.classes;

public class Cliente {
	
	public enum TipoPagamento{
		AVISTA, APRAZO;
	}
	
	private String nome;
	private TipoCliente tipoCliente;
	private TipoPagamento tipoPagamento; 
	
	public Cliente(String nome, TipoCliente tipo, TipoPagamento tipoPagamento) {
		super();
		this.nome = nome;
		this.tipoCliente = tipo;
		this.tipoPagamento = tipoPagamento;
	}

	
	/*o SMÉTODOS DA CLASSE ENUM SÃO CHAMADOS PELO ATRIBUTO DA CLASSE CLIENTE*/
	@Override
	public String toString() {
		return "Cliente -> Nome = " + nome +
				", Tipo de Cliente = " + tipoCliente.getNome() +
				", TipoPagamento = " + tipoPagamento +
				", número = " + tipoCliente.getTipo() + ".";
	}

	
	
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}



	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCliente getTipo() {
		return tipoCliente;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipoCliente = tipo;
	}
	
	
	
	

}
