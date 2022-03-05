package fundamentos;

public class TiposPrimitivos {
public static void main(String[] args) {
	//Informa��es do funcion�rio
	
	//Tipos num�ricos inteiro
	byte AnosDeEmpresa = 23;
	short numeroDeVoos = 542;
	int id = 56789;
	long pontosAcumulados = 3_134_845_223L;		 //Para indicar que o valor � long, use l ou L no final
	
	//Tipos num�ricos reais
	float salario = 11_445.44F;					//Para indicar que o valor � float, use f ou F no final
	double vendasAcumuladas = 2_991_797_103.01; // double aceita um valor m�ximo de 2^53
	
	//Tipo booleano
	boolean estaDeFerias = false; // true
	
	//Tipo caracter
	char Status = 'A'; //Ativo
	
	//Dias de Empresa
	System.out.println(AnosDeEmpresa * 365);
	
	//N�mero de viagens
	System.out.println(numeroDeVoos /2);
	
	//Pontos por real
	System.out.println(pontosAcumulados / vendasAcumuladas);
	
	System.out.println(id + "ganha -> " + salario);
	System.out.println("F�rias?" + estaDeFerias);
	System.out.println("Status " + Status);
	
	/*
	 * As vari�veis tem a inicial da primeira palavra como min�scula, por�m, tamb�m � valido usar
	 * letra inicial mai�scula desde a primeira palavra.
	 */
	
}
}
