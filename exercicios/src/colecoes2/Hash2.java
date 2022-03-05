package colecoes2;

import java.util.HashSet;

public class Hash2 {
	
	public static void main(String[] args) {
		
		HashSet<Usuario2> usuarios = new HashSet<>();
		
		usuarios.add(new Usuario2("Pedro"));
		usuarios.add(new Usuario2("Ana"));
		usuarios.add(new Usuario2("Guilherme"));
		
		boolean resultado = usuarios.contains(new Usuario2("Guilherme"));
		System.out.println(resultado);
	}

}
