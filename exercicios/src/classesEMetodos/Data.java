package classesEMetodos;

public class Data {
	int ano;
	int mes;
	int dia; 
	String teste;
	char s;
	
	String obterDataFormatada() {
		final String formato =  "A data é %d/%d/%d e %s e também %c";
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
		 * 	Você pode usar this como função (método) apenas dentro de um construtor para chamar
		 *  outro construtor. Também há a possibilidade de usar this como objeto (this.ano = x) para resolver problemas de
		 * nome entre parâmetro e atributo de instância. Também não é possível usar this para
		 * chamar um construtor no outro.
		 * 	Também posso usar o this diretamente no método (obterDataFormatada(this.dia etc))
		 * 	Uma variável local não pode ser uasada fora do método, mas uma variável de calsse ou objeto pode ser usada
		 * em um método, note que na linha 28, declarei uma inicial de mesmo tipo e nome de anoInicial, não houve errp
		 * de sintaxe, pois a variável local só existe dentro do método, também, quando se tem uma variável local,
		 *  obrigatoriamente você precisará inicializá-la.
		 *  wappers por padrão, tem valor null, e tipos primitivos númericos tem valor 0 e 0.0, boolean é false, char
		 *   é \u0000 constantes devem ser inicializadas, seja na mesma linha ou no construtor. Também é importante ressaltar
		 *   que todas as variáveis e constantes dentro do main devem ser inicializadas */

}
