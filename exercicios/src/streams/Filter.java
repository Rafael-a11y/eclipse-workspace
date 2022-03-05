     package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana",7.80,3.80,9.00);
		Aluno a2 = new Aluno("Bia",5.80,4.50,10.0);
		Aluno a3 = new Aluno("Daniel",9.80,3.20,9.00);
		Aluno a4 = new Aluno("Gui",6.80,8.40,90.55);
		Aluno a5 = new Aluno("Rebeca",7.10,3.20,8.56);
		Aluno a6 = new Aluno("Pedro",8.80,9.50,4.66);
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6);
		
		Predicate<Aluno> aprovado = a -> a.nota1 >= 7;
		Function<Aluno, String> saudacaoAprovado = a -> "Parabéns " +
		a.nome + "! Você foi aprovado(a)!";
		
		alunos.stream().filter(aprovado).
		map(saudacaoAprovado).forEach(System.out::println);
	
	}
}
