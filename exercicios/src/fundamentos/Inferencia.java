 package fundamentos;

public class Inferencia {
public static void main(String[] args) {
	double a = 4.5;			// variável iniciada.
	System.out.println(a);
	
	a = 12;
	System.out.println(a);
	
	var b = 4.5;			// O Java consegue deduzir o tipo de variável
	System.out.println(b);
	
	var c = "Texto";
	System.out.println(c);
	
	c = "Outro texto.";
	System.out.println(c);
	
	double d;				//tipo de variável declarada.
	d = 123.65;				// variável iniciada.
	System.out.println(d);	// variável impressa.
	
	var e = 123.45;
	System.out.println(e);
	/*
	 				*		 Inferir é concluir, deduzir.
	 				*Alt + cima, ou baixo, move a linha.
	 				*Ctrl + Alt + cima, ou baixo, duplica a linha.
	 */
}
}
