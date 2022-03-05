package fundamentos;

import java.util.Scanner;

public class DesafioConversao {
	
	public static void main(String[] args) {
		
		Scanner salarioEscaneado = new Scanner (System.in);
		
		System.out.print("Ol�, digite o seu saldo salarial do m�s de mar�o:");
		String salarioMarco = salarioEscaneado.next();
		
		System.out.print("Muito bem, agora insira seu saldo salarial, refente "
				+ "ao m�s de Abril: ");
		String salarioAbril = salarioEscaneado.next();
		
		System.out.print("Agora, para finalizar, insira o valor equivalente"
				+ "ao seu saldo salarial do m�s de Maio:  ");
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
		
		System.out.println("Sua m�dia salarial �: " + soma / 3);
		
		salarioEscaneado.close();		
		
	}

}
