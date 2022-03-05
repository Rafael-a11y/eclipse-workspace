package br.com.abc.javacore.ZZBclassesinternas.test;

public class ClassesLocaisTest {
	
	private String nome = "William";
	public void fazAlgumaCoisa() {
		String sobrenome = "Suane";
		//pode public ou abstract,, mas nunca os dois juntos
		class Interna{
			public void imprimeNomeExterno() {
				System.out.println(nome);
				System.out.println(sobrenome);
				
			}
		}
		Interna in = new Interna();
		in.imprimeNomeExterno();
	}
	/*Classes dentro de m�todos s�o classes locais!. N�o � poss�vel acessar um objeto da classe local, sendo assim,
	 * � necess�rio que dentro do m�todo mas fora da classe, voc� crie um objeto da classe e chame o m�todo que pertence
	 * a essa classe local, a partir disso, quando o m�todo que possui tal classe local for criado, os m�todos de classe
	 * ser� executado. M�todos de classes locais n�o podem alterar atributo de m�todo, pois, embora n�o seja
	 * preciso declarar, atributos de m�todos s�o s�o finais*/
	public static void main(String[] args) {
		ClassesLocaisTest externa = new ClassesLocaisTest();
		externa.fazAlgumaCoisa();
	}

}
