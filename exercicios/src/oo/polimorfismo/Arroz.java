package oo.polimorfismo;

public class Arroz extends Comida{	//Herdeiro de Comida
	

	public Arroz(double peso) {	//Construtor do objeto de tipo Arroz que herda o atributo peso de Comida!
		super(peso); 			//Atributos private de uma classe pai não podem ser acessados direteamen-
	}							//pelas classes herdeiras, por isso o uso de métodos construtores que a-
								//pontam para a classe pai
	
}
