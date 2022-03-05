package fundamentos;

public class Temperatura {
public static void main(String[] args) {
	double fahrenheit = 451.;
	final double AJUSTE = 32;		// final serve para denominar constante.
	final double FATOR = 5/9.0;		/* É aconselhável, e não obrigatório,
	 								que as constantes estejam declaradas com letra maiúscula*/
	double celcius = (fahrenheit - AJUSTE) * FATOR;
	System.out.println("A conversão de fahrenheit em celcius é " + celcius + "ºC");
	fahrenheit = 0;
    celcius = (fahrenheit - AJUSTE) * FATOR;
	System.out.println("A conversão de fahrenheit em celcius é " + celcius + "ºC");
	
	/*
	 * Final deve ser inserido  antes do tipo de variável para indicar que se trata de uma
	 *  constante
	 */
	
}
}
