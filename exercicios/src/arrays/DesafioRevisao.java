package arrays;

import java.util.Scanner;

public class DesafioRevisao {

	public static void main(String[] args) {
			Scanner entrada = new Scanner (System.in);
			
			System.out.print("Quantas notas s�o? ");
			int qtdNotas = entrada.nextInt();
			
			double notasAluno [] = new double [qtdNotas];
			
			double total = 0;
			for (int i = 0; i < notasAluno.length; i++) {
				System.out.println("Informe a nota "  + (i + 1) + ": ");
				notasAluno[i] = entrada.nextDouble();
				total += notasAluno[i];
			}
			
	//		for(double nota: notasAluno) {
	//			 total += nota;
			System.out.println("A m�dia � : " + (total / notasAluno.length));
			entrada.close();
		}
}
