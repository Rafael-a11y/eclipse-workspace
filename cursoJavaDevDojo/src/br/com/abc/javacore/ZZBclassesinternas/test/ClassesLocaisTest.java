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
	/*Classes dentro de métodos são classes locais!. Não é possível acessar um objeto da classe local, sendo assim,
	 * é necessário que dentro do método mas fora da classe, você crie um objeto da classe e chame o método que pertence
	 * a essa classe local, a partir disso, quando o método que possui tal classe local for criado, os métodos de classe
	 * será executado. Métodos de classes locais não podem alterar atributo de método, pois, embora não seja
	 * preciso declarar, atributos de métodos são são finais*/
	public static void main(String[] args) {
		ClassesLocaisTest externa = new ClassesLocaisTest();
		externa.fazAlgumaCoisa();
	}

}
