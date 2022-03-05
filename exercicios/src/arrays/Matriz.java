package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Matriz {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		
		System.out.print("Quantos alunos? ");
		int qtdAlunos = entrada.nextInt();
		
		System.out.print("Quantas notas por aluno? ");
		int qtdNotas = entrada.nextInt();
		
		double notasDaTurma [][] = new double [qtdAlunos][qtdNotas];
		
		double total = 0;
		for (int a = 0; a < notasDaTurma.length; a++) {
			for (int n = 0; n < notasDaTurma[a].length; n++) {
			
				System.out.printf(" Informe a nota %d do aluno %d: ", n + 1, a + 1);
				notasDaTurma [a][n] = entrada.nextDouble();
				total += notasDaTurma[a][n];
			}
		}
		double media = total / (qtdAlunos * qtdNotas);
		System.out.println(" Média da turma é : " + media);
		
		for (double  notasDoAluno [] : notasDaTurma)
		System.out.println(Arrays.toString(notasDoAluno));
		
		entrada.close();
		
		/*
		 * O for, na linha 19 a 20, percorre a matriz: a variável a representa o índice que vai percorrer os 
		 * slots dos alunos, enquanto que no for interno, a variável n representa o índice que percorre as 
		 * notas dos alunos.
		 * No for da linha 22, a variável n percorre os slots dentro do índice a, que representa os alunos,
		 * já que, dentro de cada slot a, existe um array, que é percorrido pelo índice n que representa as 
		 * notas dos alunos, por isso, na hora de percorrer as notas, usa-se n < notasDaTurma[a] (notasDaTurma
		 * é a matriz), para mostrar que é para percorrer o array dentro de a, que também é um array.
		 * Em uma estrutura de repetição, o valor só é atribuído, depois da condição ser lida e executada.
		 * Pelo que vejo, na linha 32 a 34, caso seja usado o nome da matriz como parâmetro, o que será 
		 * impresso é o endereço de memória da matriz, e não a matriz propriamente dita.
		 */
	}

}
