package classesEMetodos.DesafioModulo;

public class Jantar {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Rafael", 73.63);
		
		Comida c1 = new Comida("Feijão", 0.223);
		
		Comida c2 = new Comida("Arroz", 0.100);
		System.out.println(p1.Apresentar());
		p1.comer(c1);
		System.out.println(p1.Apresentar());
		p1.comer(c2);
		System.out.println(p1.Apresentar());
				/*
		 * Variáveis locais não são inicializadas por padrão, já as as não locais, embora sejam inicializadas 
		 * por padrão, isso não acontece com as constantes. Wrappers não
		 * inicializados recebem valor null
		 */
		
	}

}
