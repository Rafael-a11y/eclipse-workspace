package br.com.abc.javacore.Kenum.classes;

public enum TipoCliente {
	
	//constant specific class body
		//corpo de classe específico constante

	PESSOA_FISICA(1, "Pessoa Física"), PESSOA_JURIDICA(2, "Pessoa Jurídica"){
		public String getId() {
			return "B";
		}
	};
	
	/*Os atributos devem estar associados aos enums*/
	private int tipo;
	private String nome;
	
	/*Você nunca poderá chamar o construtor, ele sempre será chamado inplícitamente pela
	 * linguagem, e também, na construção do objeto, você não passa diretamente os valores,
	 * estes são inferidos pela associação que possuem com os enums, se você declara na
	 * construção do objeto que ele é TipoCliente.PESSOA_FISICA, então, o nome será
	 * Pesssoa Física, e o número será 1.*/
	private TipoCliente(int tipo, String nome){
		this.tipo = tipo;
		this.nome = nome;
	}
	
	//constant specific class body
	//corpo de classe específico constante
	
	public String getId() {
		return "A";
	}
	
	public int getTipo() {
		return tipo;
	}
	
	 public String getNome() {
		return nome;
	}
}
