package classesEMetodos;

public class TesteDeClassesEMetodos {

	int dia;
	int mes;
	int ano;
	int resultado;
	int d ; 
	
	//final static double pi = 1415;
	
	TesteDeClassesEMetodos(){
		
	}
	int  somar(int a, int b){
		resultado = a + b;
		return resultado;
	}
//	int somar2(){
//		return d = resultado;
//	}
	String  somar3(){
		String formato = "A soma é %d ";
	return 	String.format(formato, resultado);
		
	}
	void obterSoma () { 				//Sem entrada ou saída, dentro do método tenho um printf mostrando o 
		System.out.println(somar3());	// método somar3, mas somente o método, aplico a d1 dentro do main!
	}
	
} 

/*	Quando eu tentei atribuir o valor de resultado para a variável d, mesmo usando o "this.", não houve progresso.*/
