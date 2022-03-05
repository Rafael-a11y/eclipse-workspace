package fundamentos;

public class AreCircuferencia {
public static void main(String[] args) {
	double raio = 3.4;
	final double PI = 3.14159;
	double area = PI * raio * raio;
	System.out.println(area);
	raio = 10;
	area = PI * raio * raio;
	System.out.println("Área=" + area + "m2.");
	/*
	 * Não se pode fazer uma divisão inteira dentro do tipo real 
	 * (double), se não, o resultado será 0.
	 */
}
}
