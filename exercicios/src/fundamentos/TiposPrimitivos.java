package fundamentos;

public class TiposPrimitivos {
public static void main(String[] args) {
	//Informações do funcionário
	
	//Tipos numéricos inteiro
	byte AnosDeEmpresa = 23;
	short numeroDeVoos = 542;
	int id = 56789;
	long pontosAcumulados = 3_134_845_223L;		 //Para indicar que o valor é long, use l ou L no final
	
	//Tipos numéricos reais
	float salario = 11_445.44F;					//Para indicar que o valor é float, use f ou F no final
	double vendasAcumuladas = 2_991_797_103.01; // double aceita um valor máximo de 2^53
	
	//Tipo booleano
	boolean estaDeFerias = false; // true
	
	//Tipo caracter
	char Status = 'A'; //Ativo
	
	//Dias de Empresa
	System.out.println(AnosDeEmpresa * 365);
	
	//Número de viagens
	System.out.println(numeroDeVoos /2);
	
	//Pontos por real
	System.out.println(pontosAcumulados / vendasAcumuladas);
	
	System.out.println(id + "ganha -> " + salario);
	System.out.println("Férias?" + estaDeFerias);
	System.out.println("Status " + Status);
	
	/*
	 * As variáveis tem a inicial da primeira palavra como minúscula, porém, também é valido usar
	 * letra inicial maiúscula desde a primeira palavra.
	 */
	
}
}
