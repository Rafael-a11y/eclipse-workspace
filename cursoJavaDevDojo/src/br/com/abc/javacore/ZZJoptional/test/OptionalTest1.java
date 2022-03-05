package br.com.abc.javacore.ZZJoptional.test;

import java.util.Optional;

public class OptionalTest1 {
	private String nome;
	public static void main(String[] args) {
		OptionalTest1 ot = new OptionalTest1();
//		Quando voc� tem certeza que o valor n�o � nulo.
		Optional<String> optional1 = Optional.of("DevDojo"); 
//		Quando a vari�vel for vazia
		Optional<String> optional2 = Optional.empty();
//		Quando voc� n�o tem certeza se a vari�vel � nula ou n�o.
		Optional<String> optional3 = Optional.ofNullable(ot.nome);
//		Imprimindo
//		Caso voc� tente usar o get() num Optional sem valor, seja um oriundo empty() ou ofNullable()(caso n�o tenha valor), lan�a
//		um NoSuchElementException. Caso voc� tente usar orElse() em uma Optional que seja atributo de um objeto, e este estando
//		lan�a uma NullPointerException. O mesmo acontece caso voc� tente usar o IsPresent() ou qualquer outro m�todo, para isso
//		n�o acontecer, o Optional deve sempre conter um valor, isso n�o quer dizer que a vari�vel que guarda o nome deve estar
//		sempre preenchida, mas a vari�vel Optional deve sempre apontare para algum valor ou vari�vel, sendo assim, o Optional deve
//		sempre apontar para alguma vari�vel ou valor, mas esta vari�vel que � referenciada por Optional pode sim ser nula, ou
//		ent�o a Optional deve apontar para um empty() ou ofNullable(), ou of(), sendo que este �ltimop deve sempre estar preenchido
//		por algum valor, e o ofNullable() aceita serr nulo, exemplo: ofNullable(null). Mas o objeto Optional sempre deve conter
//		um desses m�todos.
		System.out.println(optional1);
		System.out.println(optional2);
		System.out.println(optional3);
//		Buscando valores
		System.out.println(optional1.get()); 
		System.out.println(optional2.orElse("vazio fih!"));
//		System.out.println(optional3.orElse("vazio tamb�m fihh"));
//		if(ot.nome.isPresent()) System.out.println(ot.nome);
//		System.out.println(ot.nome.orElse("nul�o"));
	}

}
