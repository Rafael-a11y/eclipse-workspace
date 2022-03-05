package classesEMetodos;

public class Data {
	int ano;
	int mes;
	int dia; 
	String teste;
	char s;
	
	String obterDataFormatada() {
		final String formato =  "A data � %d/%d/%d e %s e tamb�m %c";
		return  String.format(formato, this.dia, mes, ano, teste, s);
	}
	
	void imprimirDataFormatada (){
		System.out.println(obterDataFormatada());
	}
		Data(){
			//dia = 1;
			//mes = 1;
			//ano = 1970;
			this(1, 1, 1970); 
			 
		}
		Data(int dia, int mes, int anoInicial){
			this.ano = anoInicial;
			this.mes = mes;
			this.dia = dia ;
		}
		
		//int anoInicial = 3;
		/*
		 * 	Voc� pode usar this como fun��o (m�todo) apenas dentro de um construtor para chamar
		 *  outro construtor. Tamb�m h� a possibilidade de usar this como objeto (this.ano = x) para resolver problemas de
		 * nome entre par�metro e atributo de inst�ncia. Tamb�m n�o � poss�vel usar this para
		 * chamar um construtor no outro.
		 * 	Tamb�m posso usar o this diretamente no m�todo (obterDataFormatada(this.dia etc))
		 * 	Uma vari�vel local n�o pode ser uasada fora do m�todo, mas uma vari�vel de calsse ou objeto pode ser usada
		 * em um m�todo, note que na linha 28, declarei uma inicial de mesmo tipo e nome de anoInicial, n�o houve errp
		 * de sintaxe, pois a vari�vel local s� existe dentro do m�todo, tamb�m, quando se tem uma vari�vel local,
		 *  obrigatoriamente voc� precisar� inicializ�-la.
		 *  wappers por padr�o, tem valor null, e tipos primitivos n�mericos tem valor 0 e 0.0, boolean � false, char
		 *   � \u0000 constantes devem ser inicializadas, seja na mesma linha ou no construtor. Tamb�m � importante ressaltar
		 *   que todas as vari�veis e constantes dentro do main devem ser inicializadas */

}
