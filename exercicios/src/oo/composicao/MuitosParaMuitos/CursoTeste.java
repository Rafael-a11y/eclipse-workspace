package oo.composicao.MuitosParaMuitos;

public class CursoTeste {
	
	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno("Rafael");
		Curso curso1 = new Curso("Java Completo");
		Aluno aluno2 = new Aluno("Luiza");
		Curso curso2 = new Curso("Pacote Full Stack");
		Aluno aluno3 = new Aluno("Deividi");
		Curso curso3 = new Curso("Desenvolvedor Web");
		
		aluno2.adicionarCurso(curso1);
		aluno2.adicionarCurso(curso2);
		aluno3.adicionarCurso(curso3);
		
		curso1.adicionarAluno(aluno1);
		for(Aluno aluno: curso1.alunos) {
			System.out.println(aluno);
		}
		System.out.println(aluno1.obterCursoPorNome("Java Completo"));
		System.out.println(aluno2.cursos.get(0));
		
		
//		System.out.println(aluno1.obterCursoPorNome("Java Completo"));
	}
}