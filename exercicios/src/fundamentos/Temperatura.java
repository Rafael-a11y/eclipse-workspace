package fundamentos;

public class Temperatura {
public static void main(String[] args) {
	double fahrenheit = 451.;
	final double AJUSTE = 32;		// final serve para denominar constante.
	final double FATOR = 5/9.0;		/* � aconselh�vel, e n�o obrigat�rio,
	 								que as constantes estejam declaradas com letra mai�scula*/
	double celcius = (fahrenheit - AJUSTE) * FATOR;
	System.out.println("A convers�o de fahrenheit em celcius � " + celcius + "�C");
	fahrenheit = 0;
    celcius = (fahrenheit - AJUSTE) * FATOR;
	System.out.println("A convers�o de fahrenheit em celcius � " + celcius + "�C");
	
	/*
	 * Final deve ser inserido  antes do tipo de vari�vel para indicar que se trata de uma
	 *  constante
	 */
	
}
}
