package oo.composicao.MuitosParaMuitos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	final String nome;
	Aluno(String nome){
		this.nome = nome;
	}
	
	List<Curso> cursos = new ArrayList<>();
	
	void adicionarCurso(Curso curso) {
		this.cursos.add(curso);
		curso.alunos.add(this);
	}
	
Curso obterCursoPorNome(String nome) {
		for(Curso curso: cursos) {
			if(curso.nome.equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		return null;
	}

public String toString() {
	return nome;
}
	
}