package classesEMetodos;

public class TesteDeClassesEMetodosComMain {
	
	public static void main(String[] args) {
		TesteDeClassesEMetodos d1 = new TesteDeClassesEMetodos();
		d1.dia = 02;
		d1.mes = 07;
		d1.ano = 2020;
		
		System.out.println(d1.somar(11, 200));
		//String obterSoma = d1.somar3();
		//System.out.println(d1.somar3());
		d1.obterSoma(); // AGORA ASSIM EU APLICO O MÉTODO EM D1
		
		TesteDeClassesEMetodos d2 = new TesteDeClassesEMetodos();
		d2.dia = 01;
		d2.mes = 06;
		d2.ano = 2019;
		
		System.out.println(d2.somar(300, 200));
		d2.obterSoma();
		System.out.println(d2.dia);
		
		/*
		 * 
		 */
		
		
		
		
		
		
		
	}

}
