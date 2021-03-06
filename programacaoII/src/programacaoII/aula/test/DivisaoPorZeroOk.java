package programacaoII.aula.test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DivisaoPorZeroOk {

	// demonstra o lan?amento de uma exce??o quando ocorre uma divis?o por zero
		public static int quotient(int numerator, int denominator) throws ArithmeticException {
			return numerator / denominator; // poss?vel divis?o por zero
		}

		public static void main(String[] args) {
			Scanner scanner = null;
			boolean continueLoop = true; // determina se mais entradas s?o necess?rias
			do {
				try { // l? dois n?meros e calcula o quociente
					scanner = new Scanner(System.in);
					System.out.print("Informe um numerador inteiro: ");
					int numerator = scanner.nextInt();
					System.out.print("Informe um denominador inteiro: ");
					int denominator = scanner.nextInt();
			
					int result = quotient(numerator, denominator);
					System.out.printf("%nResultado: %d / %d = %d%n", numerator,
					denominator, result);
					continueLoop = false; // entrada bem-sucedida; fim do loop
				} 
				catch(InputMismatchException e) {
					System.out.printf("%nException: %s%n", e );
					System.out.println("Tente novamente");
					scanner.nextLine();
				}
				catch (ArithmeticException | NoSuchElementException | IllegalStateException excecao){
					System.err.printf("%nException: %s%n", excecao);
					System.out.println("Tente Novamente");
					scanner.nextLine();
				}
				finally {
					System.out.println("Dentro do finally");
					scanner.close();
				}

			} while (continueLoop);

		}
}

