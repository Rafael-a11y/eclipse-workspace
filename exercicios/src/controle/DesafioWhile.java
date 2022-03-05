package controle;

import java.util.Scanner;

public class DesafioWhile {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		int QuantidadeDeNotas = 0;
		double nota = 0;
		double total = 0;
		
		
		// Enquanto nota for diferente de 0 (relacional) faça:
		while (nota != -1) {	
			System.out.print("\n\nInforme a nota: ");
			nota = entrada.nextDouble();
			//  Só conta o total de notas inseridas e as soma se e somente se 
			//o número for menor ou igual a 10 e maior ou igual a 10-3
			if (nota >= 0 && nota <= 10) {
			total += nota;		 //soma de todas as notas
			QuantidadeDeNotas++; //contador
			}// se a nota não estiver entre 0 e 10, e se for diferente de -1
			else if (nota != -1){
				System.out.print("\nnota inválida");
			}
		}
		// calculando a média
		double media = total / QuantidadeDeNotas;
		System.out.println("A média é : " + media);
		
		entrada.close();
	}
	
}
/*
 * 
*/
