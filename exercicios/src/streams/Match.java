package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Match {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 3.1);
		Aluno a2 = new Aluno("Luna", 4.1);
		Aluno a3 = new Aluno("Gui", 4.1);
		Aluno a4 = new Aluno("Gabi", 0);
		
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4); 
		Predicate<Aluno> aprovado = a -> a.nota1 >= 7;
		Predicate<Aluno> reprovado = aprovado.negate();
		/*allMatch() verifica se todos os elemenbtos batem o
		 * predicado passado de parâmetro*/
		System.out.println(alunos.stream().allMatch(aprovado));
		/*anyMatch() verifica se pelo menos um dos elementos bate
		 * com o predicado passado de parâmetro*/
		System.out.println(alunos.stream().anyMatch(aprovado));
		/*noneMatch() verifica se nenhum dos elementos bateu com o 
		 * predicado passado de parâmetro (é o allMatch() negado),
		 * caso todos os elementos deêm falso para allMatch(),
		 * noneMatch recebe true.*/
		System.out.println(alunos.stream().noneMatch(aprovado));
		/*Todas estas funções são terminadoras.*/
	}

}
