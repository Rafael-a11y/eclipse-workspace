package streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Filter {

	public static void main(String[] args) {
		
//		Integer[] inteiros = new Integer[10];
//		Integer[] inteiros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
//		for (int i = 0; i < inteiros.length; i++) {
//			if(inteiros[i] % 2 == 0) {
//				System.out.print("\nN�meros pares: " + inteiros[i]);
//			}
//		}
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Bia", 5.8);
		Aluno a3 = new Aluno("Daniel",9.8);
		Aluno a4 = new Aluno("Gui",6.8);
		Aluno a5 = new Aluno("Rebeca",7.1);
		Aluno a6 = new Aluno("Pedro",8.8);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6);
		
		alunos.stream().filter(a -> a.nota > 7 ).
		map(a -> "Parab�ns " + a.nome  + ", voc� foi aprovado").
		forEach(System.out::println);
		
		
	}
}
