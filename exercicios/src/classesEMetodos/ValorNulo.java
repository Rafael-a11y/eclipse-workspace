package classesEMetodos;

public class ValorNulo {
	
	public static void main(String[] args) {
		
		String s1 = "";
		System.out.println(s1.concat("!!!"));
		
		Data d1 = Math.random() > 0.5 ? new Data() : null;
		
		if (d1 != null) {
			d1.mes = 3;
			System.out.println(d1.obterDataFormatada());
		}
		
		String s2 = Math.random() > 0.5 ? "Opa" : null;
		if (s2 != null) {
			
			System.out.println(s2.concat("!!!"));
		}
	}
/*
 * Será que tem como criar um objeto usando um método que não seja construtor?
 * Math.random() gera randônicamente um número entre 0 e 1. Se você tentar acessar um atributo ou comportamento de um objeto nulo, você terá
 * um erro!
 */
}
