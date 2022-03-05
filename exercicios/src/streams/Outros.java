package streams;

import java.util.Arrays;
import java.util.List;

public class Outros {
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("Gabi", 10);
		Aluno a5 = new Aluno("Ana", 7.1);
		Aluno a6 = new Aluno("Pedro", 7.1);
		Aluno a7 = new Aluno("Gui", 8.1);
		Aluno a8 = new Aluno("Maria", 10);
		
		List<Aluno> alunos = Arrays.asList
				(a1,a2,a3,a4, a5,a6,a7,a8);
		/*distinct() s� funciona corretamente com o equals() e 
		 * hashCode() gerados, pois distinct, a princ�pio aponta
		 * para o endere�o d mem�ria.*/
		System.out.println("Distinct... ");
		
		alunos.stream()
		.distinct()
		.forEach(System.out::println);
		/*skip() pula os primeiros elementos da stream, ocultan-
		 * do-os, j� o limit() determina at� quais elementos ser�
		 * impressa a stream.*/
		System.out.println("\nSkip/Limit...");
		alunos.stream().distinct().limit(2).skip(1).
		forEach(System.out::println);
		/*tkaeWhile() vai capturando elementos at� que o predicado
		 * seja verdadeiro, quando o predicado � falso, o m�todo
		 * takeWhile() deixa de capturar os elementos*/
		System.out.println("\ntakeWhile...");
		alunos.stream().distinct().skip(2).takeWhile(a -> a.nota1 >= 7).
		forEach(System.out::println);
	} 

}
