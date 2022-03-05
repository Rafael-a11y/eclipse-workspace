package TiposDeDados;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTeste2 {

	public static void main(String[] args) {
		Seguradora seguradora = new Seguradora("DevDojo Seguros");
		Carro carro = new Carro(seguradora, "Audi");
		Pessoa p = new Pessoa(carro, "Carlos");
		checarNomeSeguradora(seguradora);
		checarNomeSeguradoraOptional(seguradora);
//		System.out.println();
		p.setIdade(20);
		System.out.println(obterNomeSeguradoraComIdade(p, 18));
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(Optional.ofNullable(map.get("kakakak")).orElse("Chave n�o existe"));
		System.out.println(stringToInt("2"));
		
	}
	
	private static Optional<Integer> stringToInt(String numero){
		try {
			return Optional.of(Integer.parseInt(numero));
		}
		catch(NumberFormatException e){
			return Optional.empty();
		}
	}
	
	public static void checarNomeSeguradora(Seguradora seguradora) {
		if(seguradora != null && seguradora.getNome() != null &&
				seguradora.getNome().equalsIgnoreCase("DevDojo Seguros"));
		System.out.println("� o DevDojo");
		
	}
	
	private static void checarNomeSeguradoraOptional(Seguradora seguradora) {
		Optional.ofNullable(seguradora).filter(s -> s.getNome().
				equals("DevDojo Seguros")).
					ifPresent(x -> System.out.println("� o devdojo"));
		
	}
	
	private static String obterNomeSeguradoraComIdade(Pessoa p, int idadeMinima) {
		return Optional.ofNullable(p).filter(pe-> pe.getIdade() >= idadeMinima).
		flatMap(Pessoa::getCarro)
		.flatMap(Carro::getSeguradora).
			map(Seguradora::getNome).orElse("N�o existe seguradora ou a idade m�nima n�o"
					+ " foi atingida");
	}
	
	public static String obterNomeSeguradora(Optional <Pessoa> p) {
		
		return p.flatMap(Pessoa::getCarro)
			.flatMap(Carro::getSeguradora).
				map(Seguradora::getNome).orElse("N�o existe seguradora");
	}
	
}
