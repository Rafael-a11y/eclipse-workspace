package excecao.loiane;

public class Excecao {

	public static void main(String[] args) {
		
		int[] vetor = new int[4];
		ArrayIndexOutOfBoundsException erro = null;
		
		System.out.println("Antes do erro acontecer!");
		
		try {
			vetor[4] = 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("Você tentou acessar uma posição fora do array");
			erro = e;
		}
			System.out.println("Este texto não será impresso!");
			if(erro == null) {
			
		}
		System.out.println("Este erro será impresso se houver tratamento de erros");
		
		
	}
}
