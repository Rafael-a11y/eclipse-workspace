package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

public class Carro {
	private Seguradora seguradora;
	private String nome;
	
	public Carro() {
		
	}
	public Carro(String nome, Seguradora seguradora) {
		this.nome = nome;
		this.seguradora = seguradora;
	}
	public Carro(String nome) {
		this.nome = nome;
	}
	public Optional<Seguradora> getSeguradora() {
		return Optional.ofNullable(seguradora);
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
