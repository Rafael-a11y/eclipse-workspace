package classesEMetodos;

public class AreaCircRevisao {
	
	double raio;
	static final double PI = 3.1415;
	
	AreaCircRevisao(double raioInicial){
		raio = raioInicial; 
	}
	 double area() {
		return PI * Math.pow(raio, 2);
	}
	static double area(double raio) {
		return PI * Math.pow(raio, 2);
	}
	/*
	 * É necessário o método ser estático para usá-lo no atributo de classe
	 */
}
