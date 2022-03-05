package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;
//Usamos o Optional somente no m�todo getNome() porque o Optional n�o foi criado com o intuito de servir de campo, por isso,
//embora usemos Optional para o campo nome, n�o envolvemos o campo nome dentro de Optional em sua declara��o, somente no m�todo
//getNome(), dependendo do framework que voc� for usar, poder� ter s�rios problemas se usar o Optional como campo da classe.
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
