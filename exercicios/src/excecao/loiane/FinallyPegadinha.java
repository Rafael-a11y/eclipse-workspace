package excecao.loiane;

import java.util.Scanner;

public class FinallyPegadinha {
	
	public static void main(String[] args) {
		
		int[]  numeros = {4, 8, 16, 32, 64, 128};
		int[] denominadores = {2, 0, 4, 8, 0};
		
		for (int i = 0; i < numeros.length; i++) {
			try {
				System.out.println(numeros[i] + "/" + denominadores[i] + " = " +
						(numeros[i] / denominadores[i]));
			}
			catch(ArithmeticException e1){
				System.out.println("Erro ao tentar dividir por zero");
				System.exit(0);
			}
			catch(ArrayIndexOutOfBoundsException e2) {
				System.out.println("Erro ao tentar acessar uma posição fora do array");
//				System.exit(0);				
			}
			finally {
				System.out.println("Esta linha sempre é impressa após o try ou o catch");
				System.out.println();
			}
		}
		Scanner entrada = new Scanner(System.in);
		System.out.print("\nEntre com um número :");
		System.out.print(10 / entrada.nextInt());
	}

}
