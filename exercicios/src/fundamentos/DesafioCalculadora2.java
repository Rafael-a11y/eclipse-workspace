package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora2 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Pois bem, digite um n�mero: ");
		String n1 = entrada.next();
		System.out.println("Agora entre com mais um n�mero: ");
		String n2 = entrada.next();
		System.out.println("Agora escolha: soma, subtra��o, divis�o ou multiplica��o: ");
		String aritimetico = entrada.next();
		
		Double valor1 = Double.parseDouble(n1);
		Double valor2 = Double.parseDouble(n2);
		Double soma = valor1 + valor2;
		Double subtracao = valor1 - valor2;
		Double divisao = valor1 / valor2;
		Double multiplicacao = valor1 * valor2;
		String soma1 = soma.toString(soma);
		String subtracao1 = subtracao.toString(subtracao);
		String divisao1 = divisao.toString(divisao);
		String multiplicacao1 = multiplicacao.toString(multiplicacao);
		String soma2 = "soma".equalsIgnoreCase(aritimetico) ? soma1 : "S� � permitido as 04 b�sicas opera��es aritim�ticas!";
		String subtracao2 = "subtra��o".equalsIgnoreCase(aritimetico) ? subtracao1 : soma2;
		String divisao2 = "divis�o".equalsIgnoreCase(aritimetico) ? divisao1 : subtracao2;
		String multiplicacao2 = "multiplica��o".equalsIgnoreCase(aritimetico) ? multiplicacao1 : divisao2;
		String resultado = multiplicacao2;
		System.out.println(resultado);
		entrada.close();
		
		
		
	}
}
