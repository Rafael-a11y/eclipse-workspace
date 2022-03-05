package excecao.loiane;

import java.util.Scanner;

public class UsandoThrows {
	
	public static void main(String[] args) {
		/*E seu eu trtar a exceção no método?*/
		System.out.println("Entre com um número: ");
		try {
			double numero = lerNumero();
			System.out.println("Você digitou " + numero);
		} 
		catch (Exception e) {
			System.out.println("Entrada inválida");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static double lerNumero() throws Exception {
		Scanner entrada = new Scanner(System.in);
		double numero = entrada.nextDouble();
		entrada.close();
		return numero;
	}

}
