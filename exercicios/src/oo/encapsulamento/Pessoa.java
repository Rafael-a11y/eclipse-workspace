package oo.encapsulamento;

public class Pessoa {
	
	private String nome;
	private String sobrenome;
	private int idade;
	
	Pessoa(String nome, String sobrenome, int idade){
		setNome(nome);
		setSobrenome(sobrenome);
		setIdade(idade);
	}
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeCompleto() {
		return getNome() + " " + getSobrenome();
	}

	//Getter -> get significa obter no inglês, obter, ler...
	public 	int getIdade() {
		return idade;
	}
	//Setter -> set é definir no inglês, definir, alterar...
	public void setIdade(int novaIdade) {
		novaIdade = Math.abs(novaIdade);
		if(novaIdade >= 0 && novaIdade <=120) {
			this.idade = novaIdade;
		}
	}

//public String toString() {
//	return "Oh painho, minha idade é " + idade; quando uso o método toSring como público, ele é ativado
//}												automaticamente, basta eu apenas pedir para imprimir o
//												objeto dentro de System.out.println();
	
	public String toString() {
		return "Olá, meu nome é " + getNome() + " e tenho " + getIdade() + " anos!!";
	}
}												
