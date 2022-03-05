package oo.heranca;

public class Monstro extends Jogador{

	public Monstro(){
		this(0,0);
	}
	
	//Embora a classe pai não tenha um construtor padrão, ao criar o objeto, dentro do seu construtor
	//padrão, chamei o construtor explícito, que chama o construtor explícito da classe pai, dessa 
	//forma, consigo usar o construtor padrão para criar o objeto de forma neutra(sem atributos preenchidos),
	//mesmo que a classe pai não tenha um construtor padrão.
	
	public Monstro(int x, int y){ 
		super(x, y);
	}
}
