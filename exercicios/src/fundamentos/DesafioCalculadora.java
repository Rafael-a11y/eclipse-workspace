 package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("entre com um n�mero: ");
		String n1 = entrada.next();
		System.out.print("\nEntre com outro n�mero: ");
		String n2 = entrada.next();
		System.out.println("escolha: soma, ou subtra��o, ou divis�o, ou \nmultiplica��o: ");
		String opcao = entrada.next();
		
		double valor1 = Double.parseDouble(n1);
		double valor2 = Double.parseDouble(n2);
		Double soma = valor1 + valor2;
		Double subtracao = valor1 - valor2;
		Double multiplicacao = valor1 * valor2;
		Double divisao = valor1 / valor2;
		String somaSoma = soma.toString();
		String subtracaoSubtracao = subtracao.toString();
		String multiplicacaoMultiplicacao = multiplicacao.toString();
		String divisaoDivisao = divisao.toString();
		String soma1 = "soma".equalsIgnoreCase(opcao) ? somaSoma :"subtra��o".equalsIgnoreCase(opcao) ?
				subtracaoSubtracao :"divis�o".equalsIgnoreCase(opcao) ?
						divisaoDivisao :"multiplica��o".equalsIgnoreCase(opcao) ?
								multiplicacaoMultiplicacao :"nada";
		System.out.println(soma1);
		entrada.close();
		
		
		
	}
}
