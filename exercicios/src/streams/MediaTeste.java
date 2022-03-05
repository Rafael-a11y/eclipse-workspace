package streams;

public class MediaTeste {
	public static void main(String[] args) {
		/*Se o método adicionar retorna Media, significa que ele
		 * retorna a própria instância, sendo assim, é possível
		 * criar uma pipe line na linha de criação da instância, já 
		 * que a função retorna a própria instância, retorna Media*/
		Media m1 = new Media().adicionar(8.3).adicionar(6.7);
		Media m2 = new Media().adicionar(7.9).adicionar(6.6);
		System.out.println(m1.getValor());
		System.out.println(m2.getValor());
		System.out.println(Media.combinar(m1, m2).getValor());
		
	}
}
