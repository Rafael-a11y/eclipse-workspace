package excecao;

public class ChecadaVsNaoChecada {
	/*Declarar que o main() lan�a exce��es, tira do m�todo da exce��o checada, a obrigat�rie-
	 * dade de trat�-la, sendo assim, n�o h� mensagem de erro de tradu��o, mas n�o significa
	 * que a exce��o n�o v� acontecer, lembrando que o main(), ao declarar que lan�a exce��es,
	 * embora a n�o apare�a mensagem de erro de tradu��o do n�o tratamento da exce��o, n�o si-
	 * gnifica que a exce��o n�o deva ser tratada, ali�s, o seu algor�tmo para de funcionar n�?
	 * */
	public static void main(String[] args) throws Exception{
		
		try {
			geraErro1();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			getMessage() serve para capturar a mensagem associada a exce��o
//			e.printStackTrace(); serve para mostrar a pilha de m�todos, para que o programador
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
		/*N�o checada (o programador n�o � obrigado a tratar, se a exce��o fosse checada, o
	programnador, caso tentasse lan�ar a exce��o, teria que obrigatoriamente trat�-la)*/
		static void geraErro1() {
			throw new RuntimeException("Ocorreu um erro bem legal aqui #01!");
		}
		/*Por ser checada, ao tentar lan��-la, obrigatoriamente, a assinatura do m�todo
		 * deve possuir a palavra reservada throws e o tipo da exce��o, logo, ao declarar
		 * que o m�todo lan�a uma exce��o, o m�todo, no main() deve ser tratado*/
		static void geraErro2() throws Exception {
			
				throw new Exception("Ocorreu um erro bem legal aqui #02!");
		}
}
