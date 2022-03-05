package br.com.abc.javacore.ZZJoptional.test;
//Optional aparentemente sobrescreve algumas functions e tem acesso a classe Stream().
import java.util.Optional;

import br.com.abc.javacore.ZZJoptional.classes.Carro;
import br.com.abc.javacore.ZZJoptional.classes.Pessoa;
import br.com.abc.javacore.ZZJoptional.classes.Seguradora;
/*Optional destina-se principalmente ao uso como um tipo de retorno de método onde há uma necessidade clara de representar 
 * "nenhum resultado" e onde o uso de null pode causar erros. Uma variável cujo tipo é Optional nunca deve ser nula; ele deve 
 * sempre apontar para uma instância Optional.*/
public class OptionalTest2 {

	public static void main(String[] args) {
		Seguradora seguradora = new Seguradora("DevDojo Seguros");
		Carro carro = new Carro("Audi", seguradora);
		Pessoa p = new Pessoa(carro, "Carlos", 10);
		p = null;
//		Usando map() e flatMap() não acontece uma Exception, mas mesmo que eu use um orElese(), caso não use essas lambdas,
//		Acontece Exceptions
		System.out.println(obterNomeSeguradora(Optional.ofNullable(p)));
//		System.out.println(obterNomeSeguradora(Optional.ofNullable(p)));
//		checarNomeSeguradoraOptional(seguradora);
//		System.out.println(obterNomeSeguradoraComIdade(p, 18));
//		Uma forma de poder manipular dados sem que estes retornem nulo, é encapsulando com um Optional, desta maneira, você
//		consegue contornar melhor essas situações
//		Map<String, String> map = new HashMap<>();
//		System.out.println(Optional.ofNullable(map.get("kakaka")).orElse("Chave não existe"));
//	System.out.println(stringToInt("3"));
		Optional<String> op = Optional.of("arroz");
		op.stream();
	}
	private static Optional<Integer> stringToInt(String numero){
		try {
			return Optional.ofNullable(Integer.parseInt(numero));		}
		catch(NumberFormatException e) {
			return Optional.empty();
		}
	}
	
	private static void checarNomeSeguradora(Seguradora seguradora) {
		if(seguradora != null && seguradora.getNome().equals("DevDojo Seguros")) System.out.println(seguradora.getNome());
	}
	
	private static void checarNomeSeguradoraOptional2(Optional <Seguradora> s) {
		System.out.println(s.map(Seguradora::getNome).orElse("Não existe seguradora com este nome"));
	}
	private static void checarNomeSeguradoraOptional(Seguradora seguradora) {
		
		Optional.ofNullable(seguradora).filter((s) -> s.getNome().equals("DevDojo Seguros")).ifPresent((x) -> 
		System.out.println(x.getNome()));		
	}	
//	Vamos dizer que você quer chamar este método e digitar o nome de uma pessoa que não existe, existindo a possibilidade desta
//	pessoa ser nula. O orElse() deve retornar um valor de tipo igual ao valor que o objeto Optional guarda. o flatMap() é similar
//	ao map(), mas não cria vários Optionals aninhados, há outra diferença, que é que a função que ele aceita é uma cujo resultado
//	é um Optional, a map. Depois, provavelmente voltarei aqui para investigar mais. Usando os maps não dá exception. Só é
//	possível chamar o orElse() com map ou flatMap pois estes retornam Optionals, e o orElse() é um método de instância Optional.
	public static String obterNomeSeguradora(Optional<Pessoa> p) {
		return p.get().getCarro().get().getSeguradora().get().getNome();
	}
//	Se o resultado for retornar um Optional, use um flatMap(), caso contrário, use o map().
	private static String obterNomeSeguradoraComIdade(Pessoa p, int idadeMinima) {
		return Optional.ofNullable(p).filter((pp) -> pp.getIdade() >= idadeMinima).flatMap(Pessoa::getCarro)
		.flatMap(Carro::getSeguradora).map(Seguradora::getNome).orElse("Não existe seguradora, ou a idade "
				+ "mínima não foi atingida");
		
	}
//	orElese(): String, muito bom para se usar, já possui o get imbutido nele e não deixa uma NullPointerException ocorrer.
//	orElse só pode ser chamado por uma string e não pode ser associado a um Optional de Optional de uma String.
//	public static String obterNomeSeguradoraOptional(Seguradora seguradora) {
//		return seguradora.getNome().orElse("Não há nome");
//		System.out.println(Optional.ofNullable(seguradora).map(Seguradora::getNome).orElse(Optional.of("Vazio")));
//		System.out.println(Optional.ofNullable(seguradora).flatMap(Seguradora::getNome).orElse("Vazio"));
//		return "";
//	}
//	Caso você não use o Generics, o Optional vai envlver o objeto e não o nome! O orElse() retorna o valor String do atributo
//	 ou retorna uma mensagem que o desenvolvedor escolher. 
//	public static String obterNomeSeguradora(Seguradora seguradora) {
//		String nome = "";
//		if(seguradora.getNome() != null) nome = seguradora.getNome();
//		return nome;
//	}
//	public static String obterNomeSeguradoraTest(Seguradora seguradora) {
//		Optional<String> op = Optional.ofNullable(seguradora.getNome());
//		return op.orElse("Não há um nome");
//	}

}
