package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("Gabi", 10);
		
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4);
		
		Comparator<Aluno> melhorNota = (aluno1, aluno2) -> {
			if (aluno1.nota1 > aluno2.nota1) return 1;
			if (aluno1.nota1 < aluno2.nota1) return -1;
			return 0;
		};	
		Comparator<Aluno> piorNota = (aluno1, aluno2) -> {
			/*O 1 representa true para a primeira subexpressão
			 * predicado*/
			if (aluno1.nota1 > aluno2.nota1) return -1;
			/*O -1 representa true mas para a segunda subexpressão
			 * predicado*/
			if (aluno1.nota1 < aluno2.nota1) return 1;
			//O 0 representa false caso nenhuma das condições
			//sejam bem sucedidas.
			return 0;
		};	
		//Pega o último 1?
		//System.out.println(alunos.stream().max(melhorNota).get());
		System.out.println(alunos.stream().min(piorNota).get());
		//Pega o último -1?
		//System.out.println(alunos.stream().min(melhorNota).get());
		System.out.println(alunos.stream().max(piorNota).get());
	}
}
