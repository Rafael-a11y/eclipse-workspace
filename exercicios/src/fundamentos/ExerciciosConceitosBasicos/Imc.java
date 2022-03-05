package fundamentos.ExerciciosConceitosBasicos;

public class Imc {
	
	public static void main(String[] args) {
		
		double peso = 70;
		double altura = 1.70;
		final double formula = Math.pow(altura, 2);
		double Imc = peso / formula;
		System.out.println(Imc);
	}

}
