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
		System.out.println(" M�dia da turma � : " + media);
		
		for (double  notasDoAluno [] : notasDaTurma)
		System.out.println(Arrays.toString(notasDoAluno));
		
		entrada.close();
		
		/*
		 * O for, na linha 19 a 20, percorre a matriz: a vari�vel a representa o �ndice que vai percorrer os 
		 * slots dos alunos, enquanto que no for interno, a vari�vel n representa o �ndice que percorre as 
		 * notas dos alunos.
		 * No for da linha 22, a vari�vel n percorre os slots dentro do �ndice a, que representa os alunos,
		 * j� que, dentro de cada slot a, existe um array, que � percorrido pelo �ndice n que representa as 
		 * notas dos alunos, por isso, na hora de percorrer as notas, usa-se n < notasDaTurma[a] (notasDaTurma
		 * � a matriz), para mostrar que � para percorrer o array dentro de a, que tamb�m � um array.
		 * Em uma estrutura de repeti��o, o valor s� � atribu�do, depois da condi��o ser lida e executada.
		 * Pelo que vejo, na linha 32 a 34, caso seja usado o nome da matriz como par�metro, o que ser� 
		 * impresso � o endere�o de mem�ria da matriz, e n�o a matriz propriamente dita.
		 */
	}

}
