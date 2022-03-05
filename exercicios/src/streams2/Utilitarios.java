package streams2;

import java.util.function.UnaryOperator;

public interface Utilitarios {

	//agora se trata de uma interface para impedir o instanciamento
	public static  UnaryOperator<String> maiuscula = n -> n.toUpperCase();
	// charAt() mais "" gera uma String com a primeira letra somente.
	public static  UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";
	public static  String grito(String n) {
		return n + "!!!";
	}
}
