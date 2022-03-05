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
 * Ser� que tem como criar um objeto usando um m�todo que n�o seja construtor?
 * Math.random() gera rand�nicamente um n�mero entre 0 e 1. Se voc� tentar acessar um atributo ou comportamento de um objeto nulo, voc� ter�
 * um erro!
 */
}
