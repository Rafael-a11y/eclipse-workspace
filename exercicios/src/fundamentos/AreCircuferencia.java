package fundamentos;

public class AreCircuferencia {
public static void main(String[] args) {
	double raio = 3.4;
	final double PI = 3.14159;
	double area = PI * raio * raio;
	System.out.println(area);
	raio = 10;
	area = PI * raio * raio;
	System.out.println("�rea=" + area + "m2.");
	/*
	 * N�o se pode fazer uma divis�o inteira dentro do tipo real 
	 * (double), se n�o, o resultado ser� 0.
	 */
}
}
