package oo.composicao.MuitosParaMuitosRevisao;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	final String nome;
	final List<Aluno> alunos = new ArrayList<>();
	
	void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.cursos.add(this);
	}
	
	Curso(String nome){
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
	

}
