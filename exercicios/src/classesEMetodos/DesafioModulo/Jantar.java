package classesEMetodos.DesafioModulo;

public class Jantar {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Rafael", 73.63);
		
		Comida c1 = new Comida("Feij�o", 0.223);
		
		Comida c2 = new Comida("Arroz", 0.100);
		System.out.println(p1.Apresentar());
		p1.comer(c1);
		System.out.println(p1.Apresentar());
		p1.comer(c2);
		System.out.println(p1.Apresentar());
				/*
		 * Vari�veis locais n�o s�o inicializadas por padr�o, j� as as n�o locais, embora sejam inicializadas 
		 * por padr�o, isso n�o acontece com as constantes. Wrappers n�o
		 * inicializados recebem valor null
		 */
		
	}

}
