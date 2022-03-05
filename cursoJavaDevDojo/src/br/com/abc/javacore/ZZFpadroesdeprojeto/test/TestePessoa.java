package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pessoa;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pessoa.PessoaBuilder;

public class TestePessoa {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa.PessoaBuilder("Rafael")
				.apelido("Fafa")
				.nomeDoMeio("Souto")
				.nomeDoPai("Boanerges")
				.ultimoNome("Silva")
				.build();
		
		System.out.println(p);
		}
}
