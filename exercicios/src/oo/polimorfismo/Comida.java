package oo.polimorfismo;

public abstract class  Comida {	//Comida é pai de Arroz, Feijao, e Sorvete
	private double peso;	//Embora peso seja um atributo privado, as classes filhas herdaram tal atributo
	
	 protected Comida(double peso){	//A partir do método setPeso, o método construtor fica responsável 
		 setPeso(peso);			//por criar o objeto!	
	}

	protected double getPeso() {	//getPeso é responsável de retornar o peso da Comida
		return peso;
	}

	protected void setPeso(double peso) {	//setPeso é responsável de definir o peso do objeto, seja
		if(peso >= 0) {					//no momento da criação do objeto,  ou em outro momento que o
			this.peso = peso;			//peso do objeto precisar ser alterado.
		}
	}
	 
	 

}
