package br.com.abc.javacore.Yserializacao.classes;

import java.io.Serializable;

public class Turma {
	
	private String nome;
	
	public Turma(String nome) {
		this.nome = nome;	
	}
	
	@Override
	public String toString() {
		return "Turma {turma = " + nome + "}";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String turma) {
		this.nome = turma;
	}
}
