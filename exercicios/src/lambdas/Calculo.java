package lambdas;
@FunctionalInterface		//Interface Funcional é aquela que possui somente um método abstrato
public interface Calculo {
	
	double executar(double a, double b);
	
	default String legal() {	//ter um método default não inviabiliza a interface funcional, opcional
		return "legal";
	}
	
	
	static String muitoLegal() {//Ter um método static também não inviabiliza a interface funcional
		return  "Muito legal!";
	}
}
