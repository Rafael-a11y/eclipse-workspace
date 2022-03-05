package classesEMetodos;

public class DataRevisao {
	
	int dia;
	int mes;
	int ano;
	
	DataRevisao (){
		
	}
	DataRevisao(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	/*
	 * 	As vari�veis de par�metro existem apenas dentro do m�todo (tamb�m vale para construtor, j� que este �
	 * um m�todo especial), logo se voc� n�o usar this quando as vari�veis de par�metro forem iguais as vari�-
	 * veis de classe, voc� n�o vai fazer nada, pois as vari�veis de valor v�o receber o pr�prio valor que e-
	 * las j� possuem, enquanto as vari�vei de inst�ncia v�o continuar com o mesmo valor, seja valor padr�o o-
	 * u outro valor qualquer atribu�do anteriomente. Tamb�m vale lembrar que o this � associado a inst�ncia,
	 * sendo assim n�o � poss�vel us�-lo dentro de um m�todo est�tico, voc� pode usar o this (dentro de um con
	 * strutor ) para chamar outro construtor
	 * 
	 */
}
