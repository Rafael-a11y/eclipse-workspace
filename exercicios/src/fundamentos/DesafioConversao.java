package fundamentos;

import java.util.Scanner;

public class DesafioConversao {
	
	public static void main(String[] args) {
		
		Scanner salarioEscaneado = new Scanner (System.in);
		
		System.out.print("Olá, digite o seu saldo salarial do mês de março:");
		String salarioMarco = salarioEscaneado.next();
		
		System.out.print("Muito bem, agora insira seu saldo salarial, refente "
				+ "ao mês de Abril: ");
		String salarioAbril = salarioEscaneado.next();
		
		System.out.print("Agora, para finalizar, insira o valor equivalente"
				+ "ao seu saldo salarial do mês de Maio:  ");
		String salarioMaio = salarioEscaneado.next();
		
		salarioMarco = salarioMarco.replace(",", ".");
		salarioAbril = salarioAbril.replace(",", ".");
		salarioMaio = salarioMaio.replace(",", ".");
		
		double salarioMarcoEscaneado = Double.parseDouble(salarioMarco);
		double salarioAbrilEscaneado = Double.parseDouble(salarioAbril);
		double salarioMaioEscaneado = Double.parseDouble(salarioMaio);
		
		double soma = salarioMarcoEscaneado + 
				salarioAbrilEscaneado + 
				salarioMaioEscaneado;
		
		System.out.println("Sua média salarial é: " + soma / 3);
		
		salarioEscaneado.close();		
		
	}

}
