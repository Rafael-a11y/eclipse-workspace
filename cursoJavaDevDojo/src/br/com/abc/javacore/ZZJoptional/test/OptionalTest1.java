package br.com.abc.javacore.ZZJoptional.test;

import java.util.Optional;

public class OptionalTest1 {
	private String nome;
	public static void main(String[] args) {
		OptionalTest1 ot = new OptionalTest1();
//		Quando você tem certeza que o valor não é nulo.
		Optional<String> optional1 = Optional.of("DevDojo"); 
//		Quando a variável for vazia
		Optional<String> optional2 = Optional.empty();
//		Quando vocÊ não tem certeza se a variável é nula ou não.
		Optional<String> optional3 = Optional.ofNullable(ot.nome);
//		Imprimindo
//		Caso você tente usar o get() num Optional sem valor, seja um oriundo empty() ou ofNullable()(caso não tenha valor), lança
//		um NoSuchElementException. Caso você tente usar orElse() em uma Optional que seja atributo de um objeto, e este estando
//		lança uma NullPointerException. O mesmo acontece caso vocÊ tente usar o IsPresent() ou qualquer outro método, para isso
//		não acontecer, o Optional deve sempre conter um valor, isso não quer dizer que a variável que guarda o nome deve estar
//		sempre preenchida, mas a variável Optional deve sempre apontare para algum valor ou variável, sendo assim, o Optional deve
//		sempre apontar para alguma variável ou valor, mas esta variável que é referenciada por Optional pode sim ser nula, ou
//		então a Optional deve apontar para um empty() ou ofNullable(), ou of(), sendo que este últimop deve sempre estar preenchido
//		por algum valor, e o ofNullable() aceita serr nulo, exemplo: ofNullable(null). Mas o objeto Optional sempre deve conter
//		um desses métodos.
		System.out.println(optional1);
		System.out.println(optional2);
		System.out.println(optional3);
//		Buscando valores
		System.out.println(optional1.get()); 
		System.out.println(optional2.orElse("vazio fih!"));
//		System.out.println(optional3.orElse("vazio também fihh"));
//		if(ot.nome.isPresent()) System.out.println(ot.nome);
//		System.out.println(ot.nome.orElse("nulão"));
	}

}
