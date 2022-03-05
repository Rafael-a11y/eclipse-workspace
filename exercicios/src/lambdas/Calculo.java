package lambdas;
@FunctionalInterface		//Interface Funcional � aquela que possui somente um m�todo abstrato
public interface Calculo {
	
	double executar(double a, double b);
	
	default String legal() {	//ter um m�todo default n�o inviabiliza a interface funcional, opcional
		return "legal";
	}
	
	
	static String muitoLegal() {//Ter um m�todo static tamb�m n�o inviabiliza a interface funcional
		return  "Muito legal!";
	}
}
