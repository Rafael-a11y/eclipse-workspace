package oo.composicao.MuitosParaMuitosRevisao;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	final String nome;
	final List<Curso> cursos = new ArrayList<>();
	
	void adicionarCurso(Curso curso) {
		this.cursos.add(curso);
		curso.alunos.add(this);//Ou seja, o objeto aluno que terá acesso a este método irá adicionar
		//o objeto curso a sua grade, então este curso fará parte de sua lista de cursos, assim como
		//este aluno fará parte da lista de alunos do curso adicionado.
		
	}
	
	Aluno(String nome){
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}
	
	Curso obterCursoPorNome(String nome) {
		for(Curso curso: this.cursos) {
			if(curso.nome.trim().equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		return null;
	}
	

}
