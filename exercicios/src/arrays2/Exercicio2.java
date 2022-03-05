package arrays2;

import java.util.Arrays;

public class Exercicio2 {
	
	public static void main(String[] args) {
		
		double notasAlunoA [] = new double [3];
		notasAlunoA [0] = 7.9;
		notasAlunoA [1] = 8;
		notasAlunoA [2] = 6.7;  
		
		System.out.println( Arrays.toString(notasAlunoA));
		
		double totalAlunoA = 0;
		for(int i = 0; i < notasAlunoA.length; i++) {
			totalAlunoA += notasAlunoA[i];
		}
		System.out.println(totalAlunoA / notasAlunoA.length);
		
		final double notaArmazenada = 5.9;
		double notasAlunoB [] = {6.9, 8.9, notaArmazenada, 10 };
		double totalAlunoB = 0;
		for (int i = 0; i < notasAlunoB.length; i++) {
			totalAlunoB += notasAlunoB[i];
		}
		
		System.out.println(totalAlunoB / notasAlunoB.length);
		
		
	}

}
