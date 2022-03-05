package excecao.loiane;

import java.util.Scanner;

public class UsandoThrows {
	
	public static void main(String[] args) {
		/*E seu eu trtar a exce��o no m�todo?*/
		System.out.println("Entre com um n�mero: ");
		try {
			double numero = lerNumero();
			System.out.println("Voc� digitou " + numero);
		} 
		catch (Exception e) {
			System.out.println("Entrada inv�lida");
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
