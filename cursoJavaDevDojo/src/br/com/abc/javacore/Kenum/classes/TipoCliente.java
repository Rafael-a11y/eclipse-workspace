package br.com.abc.javacore.Kenum.classes;

public enum TipoCliente {
	
	//constant specific class body
		//corpo de classe espec�fico constante

	PESSOA_FISICA(1, "Pessoa F�sica"), PESSOA_JURIDICA(2, "Pessoa Jur�dica"){
		public String getId() {
			return "B";
		}
	};
	
	/*Os atributos devem estar associados aos enums*/
	private int tipo;
	private String nome;
	
	/*Voc� nunca poder� chamar o construtor, ele sempre ser� chamado inpl�citamente pela
	 * linguagem, e tamb�m, na constru��o do objeto, voc� n�o passa diretamente os valores,
	 * estes s�o inferidos pela associa��o que possuem com os enums, se voc� declara na
	 * constru��o do objeto que ele � TipoCliente.PESSOA_FISICA, ent�o, o nome ser�
	 * Pesssoa F�sica, e o n�mero ser� 1.*/
	private TipoCliente(int tipo, String nome){
		this.tipo = tipo;
		this.nome = nome;
	}
	
	//constant specific class body
	//corpo de classe espec�fico constante
	
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
