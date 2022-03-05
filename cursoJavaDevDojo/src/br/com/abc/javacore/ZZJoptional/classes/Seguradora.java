package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;
//Usamos o Optional somente no método getNome() porque o Optional não foi criado com o intuito de servir de campo, por isso,
//embora usemos Optional para o campo nome, não envolvemos o campo nome dentro de Optional em sua declaração, somente no método
//getNome(), dependendo do framework que você for usar, poderá ter sérios problemas se usar o Optional como campo da classe.
public class Seguradora {
	private String nome;
	
	public Seguradora(String nome) {
		this.nome = nome;
	}
	public Seguradora() {
		
	}
	@Override
	public String toString() {
		return "Seguradora { nome = " + nome + "}";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
