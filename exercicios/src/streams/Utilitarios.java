package streams;

import java.util.function.UnaryOperator;

public class Utilitarios {
	
	private Utilitarios() {
		
	}

	public static final UnaryOperator<String> maiuscula = n -> n.toUpperCase();
	public static final UnaryOperator<String> inicial = n -> n.charAt(0) + "";
	public static final String grito(String n) {
		return n + "!!! ";
	}
}
