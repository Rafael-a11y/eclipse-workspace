package TiposDeDados;

import java.util.Optional;

public class OptionalTeste1 {
	
	private String nome;
	private Integer numero;
	
	public static void main(String[] args) {
		
		OptionalTeste1 ot = new OptionalTeste1();
//		ot.nome = "Rafael";
		//Optional.of() é usada quando se tem certeza que o valor não é nulo.
		Optional<String> optional1 = Optional.of("Rafael Souto");
		//Iniciando uma Optional vazia.
		Optional<String> optional2 = Optional.empty();
		//Se usa Optional.ofNullable() quando não se sabve se o valor é nulo ou não nulo.
		Optional<String> optional3 = Optional.ofNullable(ot.nome);
		System.out.println(optional1);
		System.out.println(optional2);
		System.out.println(optional3);
//		System.out.println(ot.nome.toString());
		//Buscando valores.
		//Gera NullPointerException se estiver null.
//		if(optional2.isPresent()) {
//			System.out.println(optional2);
//		}
//		System.out.println(optional1.orElse("Vazio"));
//		System.out.println(optional2.orElse("Vazio"));
//		System.out.println(optional3.orElse("Vazio"));
		//Gera NoSuchElementException se estiver null.
//		System.out.println(optional2.get());
	}

}
