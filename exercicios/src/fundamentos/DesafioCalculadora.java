 package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("entre com um número: ");
		String n1 = entrada.next();
		System.out.print("\nEntre com outro número: ");
		String n2 = entrada.next();
		System.out.println("escolha: soma, ou subtração, ou divisão, ou \nmultiplicação: ");
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
		String soma1 = "soma".equalsIgnoreCase(opcao) ? somaSoma :"subtração".equalsIgnoreCase(opcao) ?
				subtracaoSubtracao :"divisão".equalsIgnoreCase(opcao) ?
						divisaoDivisao :"multiplicação".equalsIgnoreCase(opcao) ?
								multiplicacaoMultiplicacao :"nada";
		System.out.println(soma1);
		entrada.close();
		
		
		
	}
}
