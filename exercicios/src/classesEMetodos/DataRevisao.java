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
	 * 	As variáveis de parâmetro existem apenas dentro do método (também vale para construtor, já que este é
	 * um método especial), logo se você não usar this quando as variáveis de parâmetro forem iguais as variá-
	 * veis de classe, você não vai fazer nada, pois as variáveis de valor vão receber o próprio valor que e-
	 * las já possuem, enquanto as variávei de instância vão continuar com o mesmo valor, seja valor padrão o-
	 * u outro valor qualquer atribuído anteriomente. Também vale lembrar que o this é associado a instância,
	 * sendo assim não é possível usá-lo dentro de um método estático, você pode usar o this (dentro de um con
	 * strutor ) para chamar outro construtor
	 * 
	 */
}
