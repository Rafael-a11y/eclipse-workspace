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
			System.out.println("Voc� tentou acessar uma posi��o fora do array");
			erro = e;
		}
			System.out.println("Este texto n�o ser� impresso!");
			if(erro == null) {
			
		}
		System.out.println("Este erro ser� impresso se houver tratamento de erros");
		
		
	}
}
