package programacaoII.aula.test;

public class PesquisaEstudantes {

	public static void main(String[] args) {
		// array das respostas dos alunos (mais tipicamente, inserido em tempo de execução)
		int[] respostas = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3,
		2, 3, 3, 2, 14 };
		int[] frequencia = new int[6]; // array de contadores de frequência

		// para cada resposta, seleciona elemento de respostas e utiliza esse valor
		// como índice de frequência para determinar elemento a incrementar
		try {
			for (int resposta = 0; resposta < respostas.length; resposta++) {
				++frequencia[respostas[resposta]];

		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Tentastes acessar uma posição fora do array!");
		}
		
		System.out.printf("%s%10s%n", "Rating", "Frequency");
		// gera saída do valor de cada elemento do array
		for (int rating = 1; rating < frequencia.length; rating++)
		System.out.printf("%6d%10d%n", rating, frequencia[rating]);
		
		}
}
