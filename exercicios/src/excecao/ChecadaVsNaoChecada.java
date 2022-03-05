package excecao;

public class ChecadaVsNaoChecada {
	/*Declarar que o main() lança exceções, tira do método da exceção checada, a obrigatórie-
	 * dade de tratá-la, sendo assim, não há mensagem de erro de tradução, mas não significa
	 * que a exceção não vá acontecer, lembrando que o main(), ao declarar que lança exceções,
	 * embora a não apareça mensagem de erro de tradução do não tratamento da exceção, não si-
	 * gnifica que a exceção não deva ser tratada, aliás, o seu algorítmo para de funcionar né?
	 * */
	public static void main(String[] args) throws Exception{
		
		try {
			geraErro1();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			getMessage() serve para capturar a mensagem associada a exceção
//			e.printStackTrace(); serve para mostrar a pilha de métodos, para que o programador
//			possa tentar rastrear o erro.
	}
		
			try {
				geraErro2();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		System.out.println("Fim :{)");
	}
		/*Não checada (o programador não é obrigado a tratar, se a exceção fosse checada, o
	programnador, caso tentasse lançar a exceção, teria que obrigatoriamente tratá-la)*/
		static void geraErro1() {
			throw new RuntimeException("Ocorreu um erro bem legal aqui #01!");
		}
		/*Por ser checada, ao tentar lançá-la, obrigatoriamente, a assinatura do método
		 * deve possuir a palavra reservada throws e o tipo da exceção, logo, ao declarar
		 * que o método lança uma exceção, o método, no main() deve ser tratado*/
		static void geraErro2() throws Exception {
			
				throw new Exception("Ocorreu um erro bem legal aqui #02!");
		}
}
