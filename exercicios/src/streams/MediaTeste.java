package streams;

public class MediaTeste {
	public static void main(String[] args) {
		/*Se o m�todo adicionar retorna Media, significa que ele
		 * retorna a pr�pria inst�ncia, sendo assim, � poss�vel
		 * criar uma pipe line na linha de cria��o da inst�ncia, j� 
		 * que a fun��o retorna a pr�pria inst�ncia, retorna Media*/
		Media m1 = new Media().adicionar(8.3).adicionar(6.7);
		Media m2 = new Media().adicionar(7.9).adicionar(6.6);
		System.out.println(m1.getValor());
		System.out.println(m2.getValor());
		System.out.println(Media.combinar(m1, m2).getValor());
		
	}
}
