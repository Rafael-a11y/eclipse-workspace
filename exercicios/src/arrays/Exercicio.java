package arrays;

import java.util.Arrays;
 
public class Exercicio {

	public static void main(String[] args) {
		  double[] notasAlunoA = new double [3];
		  System.out.println(Arrays.toString(notasAlunoA));
		  notasAlunoA[0] = 7.9;
		  notasAlunoA[1] = 8;
		  notasAlunoA[2] = 6.7;
		  
		  System.out.println(Arrays.toString(notasAlunoA));
		  System.out.println(notasAlunoA[0]);
		  System.out.println(notasAlunoA[notasAlunoA.length - 1]); 
		// é o tamanho do array - 1, automaticamente mostra o valor do último vetor
//			OU
//		  String a = Arrays.toString(notasAlunoA);
//		  System.out.println(a);
		  double totalAlunoA = 0;
		  for (int i = 0; i < notasAlunoA.length; i++) {
			  totalAlunoA += notasAlunoA[i];
			}
		  System.out.println(totalAlunoA / notasAlunoA.length);
		  
		  final double notaArmazenada = 5.9;
		  double [] notasAlunoB = {6.9, 8.9, notaArmazenada, 10};
		  
		  double totalAlunoB = 0;
		  for (int b = 0; b < notasAlunoB.length; b++) {
			totalAlunoB += notasAlunoB[b];
		}
		  System.out.println(totalAlunoB / notasAlunoB.length);
	}  /*	Alt + Shift + r -> Renomeia a variável em todas as partes do algoritimo. Por convenção, usa-se a 
	letra "i" para nomear a variável/índice que vai percorrer os vetores do array. Nota-se que length é um
	atributo*/
	
}
