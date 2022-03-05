package oo.composicao.MuitosParaMuitos;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	final String nome;
	
	Curso(String nome){
		this.nome = nome;
	}
	
	List<Aluno> alunos = new ArrayList<>();
	
	void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.cursos.add(this);
	}
	
	
	public String toString() {
		return nome;
	}
	
}
