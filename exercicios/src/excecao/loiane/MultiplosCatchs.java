package excecao.loiane;

public class MultiplosCatchs {
	
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
			}
			catch(ArrayIndexOutOfBoundsException e2) {
				System.out.println("Erro ao tentar acessar uma posição fora do array");
			}
		}
	}

}
