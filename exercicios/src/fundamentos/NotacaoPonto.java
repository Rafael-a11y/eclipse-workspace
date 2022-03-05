package fundamentos;

public class NotacaoPonto {
public static void main(String[] args) {
	String s = "Bom dia X";
	s = s.replace("X", "senhora");
	s = s.toUpperCase();
	s = s.concat("!!!");
	
	System.out.println(s);
	
	String x = "Leo".toUpperCase();
	System.out.println(x);
	
	String y = "Bom dia X".replace("X", "Gui").toUpperCase().concat("!!!");
	System.out.println(y);
	System.out.println(y.length());
	/*
	 * s.toUperCase() serve para deixar a string em 
	 * letra mai�scula (String n�o � um tipo primitivo).
	 * s.replace(OldChar, NewChar) serve para substituir a String.
	 * String tem a inicial mai�scula, e a vari�vel fica entre
	 * aspas dupla.
	 * s.concat(") concatena.
	 * Tamb�m � poss�vel usar um literal tipo String sem armazena-lo
	 * numa vari�vel, .toUppercase serve para deixar o dado literal
	 * em letra mai�scula (este n�o sendo uma vari�vel).
	 * A senten�a de c�digo termina em ";", por�m
	 * tal senten�a pode ser quebrada em v�rias linhas, 
	 * antes ou depois do ponto. A nota��o ponto, funciona em
	 * todas API's do Java, exeto os 8 tipos primitivos
	 */
}
}
