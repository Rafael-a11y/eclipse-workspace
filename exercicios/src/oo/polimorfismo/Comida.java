package oo.polimorfismo;

public abstract class  Comida {	//Comida � pai de Arroz, Feijao, e Sorvete
	private double peso;	//Embora peso seja um atributo privado, as classes filhas herdaram tal atributo
	
	 protected Comida(double peso){	//A partir do m�todo setPeso, o m�todo construtor fica respons�vel 
		 setPeso(peso);			//por criar o objeto!	
	}

	protected double getPeso() {	//getPeso � respons�vel de retornar o peso da Comida
		return peso;
	}

	protected void setPeso(double peso) {	//setPeso � respons�vel de definir o peso do objeto, seja
		if(peso >= 0) {					//no momento da cria��o do objeto,  ou em outro momento que o
			this.peso = peso;			//peso do objeto precisar ser alterado.
		}
	}
	 
	 

}
