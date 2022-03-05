package br.com.abc.javacore.ZZKstreams.classes;

import java.util.List;
import static java.util.Arrays.asList;

public class Pessoa {

	private String nome;
	private int idade;
	private double salario;
	private Genero genero;
	private Maioridade maioridade;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String nome, int idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	
	public Pessoa(String nome, int idade, double salario, Genero genero) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.genero = genero;
	}
	
	public Pessoa(String nome, int idade, double salario, Genero genero, Maioridade maioridade) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.genero = genero;
		this.maioridade = maioridade;
	}

	public static List<Pessoa> bancoDePessoas(){
		return asList(
				new Pessoa("William Suane", 22, 2000, Genero.MASCULINO, Maioridade.ADULTO),
				new Pessoa("Mercy", 22, 3500, Genero.FEMININO, Maioridade.ADULTO),
				new Pessoa("Mercy", 22, 3500, Genero.FEMININO, Maioridade.ADULTO),
				new Pessoa("Ana", 17, 1985, Genero.FEMININO, Maioridade.MENOR),
				new Pessoa("Thor", 23, 1980, Genero.MASCULINO, Maioridade.ADULTO),
				new Pessoa("Hulk", 35, 8000, Genero.MASCULINO, Maioridade.ADULTO),
				new Pessoa("Flash", 29, 3200, Genero.MASCULINO, Maioridade.ADULTO),
				new Pessoa("Batman", 37, 10000, Genero.MASCULINO, Maioridade.ADULTO),
				new Pessoa ("Lanterna Verde", 17, 5000, Genero.MASCULINO, Maioridade.MENOR));
	}
	
	
	
	@Override
	public String toString() {
		return "Pessoa { nome = " + nome + " }";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Genero getGenero() {
		return genero;
	}
	public Maioridade getMaioridade() {
		return maioridade;
	}
}
