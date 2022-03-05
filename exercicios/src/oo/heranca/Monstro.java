package oo.heranca;

public class Monstro extends Jogador{

	public Monstro(){
		this(0,0);
	}
	
	//Embora a classe pai n�o tenha um construtor padr�o, ao criar o objeto, dentro do seu construtor
	//padr�o, chamei o construtor expl�cito, que chama o construtor expl�cito da classe pai, dessa 
	//forma, consigo usar o construtor padr�o para criar o objeto de forma neutra(sem atributos preenchidos),
	//mesmo que a classe pai n�o tenha um construtor padr�o.
	
	public Monstro(int x, int y){ 
		super(x, y);
	}
}
