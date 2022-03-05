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
	 * letra maiúscula (String não é um tipo primitivo).
	 * s.replace(OldChar, NewChar) serve para substituir a String.
	 * String tem a inicial maiúscula, e a variável fica entre
	 * aspas dupla.
	 * s.concat(") concatena.
	 * Também é possível usar um literal tipo String sem armazena-lo
	 * numa variável, .toUppercase serve para deixar o dado literal
	 * em letra maiúscula (este não sendo uma variável).
	 * A sentença de código termina em ";", porém
	 * tal sentença pode ser quebrada em várias linhas, 
	 * antes ou depois do ponto. A notação ponto, funciona em
	 * todas API's do Java, exeto os 8 tipos primitivos
	 */
}
}
